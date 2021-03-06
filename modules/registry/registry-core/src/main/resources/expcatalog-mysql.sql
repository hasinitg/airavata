/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
CREATE TABLE GATEWAY
(
        GATEWAY_ID VARCHAR(255),
        GATEWAY_NAME VARCHAR(255),
	      DOMAIN VARCHAR(255),
	      EMAIL_ADDRESS VARCHAR(255),
        PRIMARY KEY (GATEWAY_ID)
);

CREATE TABLE USERS
(
        USER_NAME VARCHAR(255),
        PASSWORD VARCHAR(255),
        PRIMARY KEY(USER_NAME)
);

CREATE TABLE GATEWAY_WORKER
(
        GATEWAY_ID VARCHAR(255),
        USER_NAME VARCHAR(255),
        PRIMARY KEY (GATEWAY_ID, USER_NAME),
        FOREIGN KEY (GATEWAY_ID) REFERENCES GATEWAY(GATEWAY_ID) ON DELETE CASCADE,
        FOREIGN KEY (USER_NAME) REFERENCES USERS(USER_NAME) ON DELETE CASCADE
);

CREATE TABLE PROJECT
(
         GATEWAY_ID VARCHAR(255),
         USER_NAME VARCHAR(255),
         PROJECT_NAME VARCHAR(255),
         PROJECT_ID VARCHAR(255),
         DESCRIPTION VARCHAR(255),
         CREATION_TIME TIMESTAMP DEFAULT NOW(),
         PRIMARY KEY (PROJECT_ID),
         FOREIGN KEY (GATEWAY_ID) REFERENCES GATEWAY(GATEWAY_ID) ON DELETE CASCADE,
         FOREIGN KEY (USER_NAME) REFERENCES USERS(USER_NAME) ON DELETE CASCADE
);

CREATE TABLE PROJECT_USER
(
    PROJECT_ID VARCHAR(255),
    USER_NAME VARCHAR(255),
    PRIMARY KEY (PROJECT_ID,USER_NAME),
    FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(PROJECT_ID) ON DELETE CASCADE,
    FOREIGN KEY (USER_NAME) REFERENCES USERS(USER_NAME) ON DELETE CASCADE
);

CREATE TABLE EXPERIMENT (
  EXPERIMENT_ID varchar(255),
  PROJECT_ID varchar(255),
  GATEWAY_ID varchar(255),
  EXPERIMENT_TYPE varchar(255),
  USER_NAME varchar(255),
  EXPERIMENT_NAME varchar(255),
  CREATION_TIME timestamp DEFAULT NOW(),
  DESCRIPTION varchar(255),
  EXECUTION_ID varchar(255),
  GATEWAY_EXECUTION_ID varchar(255),
  ENABLE_EMAIL_NOTIFICATION tinyint(1),
  EMAIL_ADDRESSES text,
  PRIMARY KEY (EXPERIMENT_ID),
  FOREIGN KEY (USER_NAME) REFERENCES USERS(USER_NAME) ON DELETE CASCADE,
  FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(PROJECT_ID) ON DELETE CASCADE
);


CREATE TABLE EXPERIMENT_INPUT
(
    EXPERIMENT_ID varchar(255),
    INPUT_NAME varchar(255),
    INPUT_VALUE text,
    DATA_TYPE varchar(255),
    APPLICATION_ARGUMENT varchar(255),
    STANDARD_INPUT tinyint(1),
    USER_FRIENDLY_DESCRIPTION varchar(255),
    METADATA varchar(255),
    INPUT_ORDER int(11),
    IS_REQUIRED tinyint(1),
    REQUIRED_TO_ADDED_TO_CMD tinyint(1),
    DATA_STAGED tinyint(1),
    PRIMARY KEY(EXPERIMENT_ID,INPUT_NAME),
    FOREIGN KEY (EXPERIMENT_ID) REFERENCES EXPERIMENT(EXPERIMENT_ID) ON DELETE CASCADE
);

CREATE TABLE EXPERIMENT_OUTPUT
(
    EXPERIMENT_ID varchar(255),
    OUTPUT_NAME varchar(255),
    OUTPUT_VALUE text,
    DATA_TYPE varchar(255),
    APPLICATION_ARGUMENT varchar(255),
    IS_REQUIRED tinyint(1),
    REQUIRED_TO_ADDED_TO_CMD tinyint(1),
    DATA_MOVEMENT tinyint(1),
    LOCATION varchar(255),
    SEARCH_QUERY varchar(255),
    PRIMARY KEY(EXPERIMENT_ID,OUTPUT_NAME),
    FOREIGN KEY (EXPERIMENT_ID) REFERENCES EXPERIMENT(EXPERIMENT_ID) ON DELETE CASCADE
);


CREATE TABLE EXPERIMENT_STATUS (
  STATUS_ID varchar(255),
  EXPERIMENT_ID varchar(255),
  STATE varchar(255),
  TIME_OF_STATE_CHANGE timestamp DEFAULT '0000-00-00 00:00:00',
  REASON LONGTEXT,
  PRIMARY KEY (STATUS_ID, EXPERIMENT_ID),
  FOREIGN KEY (EXPERIMENT_ID) REFERENCES EXPERIMENT(EXPERIMENT_ID) ON DELETE CASCADE
);


CREATE TABLE EXPERIMENT_ERROR (
  ERROR_ID varchar(255),
  EXPERIMENT_ID varchar(255),
  CREATION_TIME timestamp DEFAULT NOW(),
  ACTUAL_ERROR_MESSAGE text,
  USER_FRIENDLY_MESSAGE text,
  TRANSIENT_OR_PERSISTENT tinyint(1),
  ROOT_CAUSE_ERROR_ID_LIST text,
  PRIMARY KEY (ERROR_ID, EXPERIMENT_ID),
  FOREIGN KEY (EXPERIMENT_ID) REFERENCES EXPERIMENT(EXPERIMENT_ID) ON DELETE CASCADE
);

CREATE TABLE USER_CONFIGURATION_DATA (
  EXPERIMENT_ID varchar(255),
  AIRAVATA_AUTO_SCHEDULE tinyint(1),
  OVERRIDE_MANUAL_SCHEDULED_PARAMS tinyint(1),
  SHARE_EXPERIMENT_PUBLICALLY tinyint(1),
  THROTTLE_RESOURCES tinyint(1),
  USER_DN varchar(255),
  GENERATE_CERT tinyint(1),
  RESOURCE_HOST_ID varchar(255),
  TOTAL_CPU_COUNT int(11),
  NODE_COUNT int(11),
  NUMBER_OF_THREADS int(11),
  QUEUE_NAME varchar(255),
  WALL_TIME_LIMIT int(11),
  TOTAL_PHYSICAL_MEMORY int(11),
  PRIMARY KEY (EXPERIMENT_ID),
  FOREIGN KEY (EXPERIMENT_ID) REFERENCES EXPERIMENT(EXPERIMENT_ID) ON DELETE CASCADE
);


CREATE VIEW LATEST_EXPERIMENT_STATUS AS
  select ES1.EXPERIMENT_ID AS EXPERIMENT_ID, ES1.STATE AS STATE, ES1.TIME_OF_STATE_CHANGE AS TIME_OF_STATE_CHANGE
  from EXPERIMENT_STATUS ES1 LEFT JOIN EXPERIMENT_STATUS ES2 ON (ES1.EXPERIMENT_ID = ES2.EXPERIMENT_ID
    AND ES1.TIME_OF_STATE_CHANGE < ES2.TIME_OF_STATE_CHANGE)  WHERE ES2.TIME_OF_STATE_CHANGE is NULL;

CREATE VIEW EXPERIMENT_SUMMARY AS
  select E.EXPERIMENT_ID AS EXPERIMENT_ID, E.PROJECT_ID AS PROJECT_ID, E.GATEWAY_ID AS GATEWAY_ID,
  E.USER_NAME AS USER_NAME, E.EXECUTION_ID AS EXECUTION_ID, E.EXPERIMENT_NAME AS EXPERIMENT_NAME,
  E.CREATION_TIME AS CREATION_TIME, E.DESCRIPTION AS DESCRIPTION, ES.STATE AS STATE, UD.RESOURCE_HOST_ID
  AS RESOURCE_HOST_ID, ES.TIME_OF_STATE_CHANGE AS TIME_OF_STATE_CHANGE
    from ((EXPERIMENT E left join LATEST_EXPERIMENT_STATUS ES on((E.EXPERIMENT_ID = ES.EXPERIMENT_ID)))
    left join USER_CONFIGURATION_DATA UD on((E.EXPERIMENT_ID = UD.EXPERIMENT_ID))) where 1;


CREATE TABLE PROCESS (
  PROCESS_ID varchar(255),
  EXPERIMENT_ID varchar(255),
  CREATION_TIME  TIMESTAMP DEFAULT NOW(),
  LAST_UPDATE_TIME  TIMESTAMP DEFAULT '0000-00-00 00:00:00',
  PROCESS_DETAIL text,
  APPLICATION_INTERFACE_ID varchar(255),
  TASK_DAG varchar(255),
  APPLICATION_DEPLOYMENT_ID varchar(255),
  COMPUTE_RESOURCE_ID varchar(255),
  GATEWAY_EXECUTION_ID varchar(255),
  ENABLE_EMAIL_NOTIFICATION BOOLEAN,
  EMAIL_ADDRESSES text,
  PRIMARY KEY (PROCESS_ID),
  FOREIGN KEY (EXPERIMENT_ID) REFERENCES EXPERIMENT(EXPERIMENT_ID) ON DELETE CASCADE
);

CREATE TABLE PROCESS_INPUT
(
    PROCESS_ID varchar(255),
    INPUT_NAME varchar(255),
    INPUT_VALUE text,
    DATA_TYPE varchar(255),
    APPLICATION_ARGUMENT varchar(255),
    STANDARD_INPUT tinyint(1),
    USER_FRIENDLY_DESCRIPTION varchar(255),
    METADATA varchar(255),
    INPUT_ORDER int(11),
    IS_REQUIRED tinyint(1),
    REQUIRED_TO_ADDED_TO_CMD tinyint(1),
    DATA_STAGED tinyint(1),
    PRIMARY KEY(PROCESS_ID,INPUT_NAME),
    FOREIGN KEY (PROCESS_ID) REFERENCES PROCESS(PROCESS_ID) ON DELETE CASCADE
);

CREATE TABLE PROCESS_OUTPUT
(
    PROCESS_ID varchar(255),
    OUTPUT_NAME varchar(255),
    OUTPUT_VALUE text,
    DATA_TYPE varchar(255),
    APPLICATION_ARGUMENT varchar(255),
    IS_REQUIRED tinyint(1),
    REQUIRED_TO_ADDED_TO_CMD tinyint(1),
    DATA_MOVEMENT tinyint(1),
    LOCATION varchar(255),
    SEARCH_QUERY varchar(255),
    PRIMARY KEY(PROCESS_ID,OUTPUT_NAME),
    FOREIGN KEY (PROCESS_ID) REFERENCES PROCESS(PROCESS_ID) ON DELETE CASCADE
);


CREATE TABLE PROCESS_STATUS (
  STATUS_ID varchar(255),
  PROCESS_ID varchar(255),
  STATE varchar(255),
  TIME_OF_STATE_CHANGE timestamp DEFAULT '0000-00-00 00:00:00',
  REASON LONGTEXT,
  PRIMARY KEY (STATUS_ID, PROCESS_ID),
  FOREIGN KEY (PROCESS_ID) REFERENCES PROCESS(PROCESS_ID) ON DELETE CASCADE
);


CREATE TABLE PROCESS_ERROR (
  ERROR_ID varchar(255),
  PROCESS_ID varchar(255),
  CREATION_TIME timestamp DEFAULT NOW(),
  ACTUAL_ERROR_MESSAGE text,
  USER_FRIENDLY_MESSAGE text,
  TRANSIENT_OR_PERSISTENT tinyint(1),
  ROOT_CAUSE_ERROR_ID_LIST text,
  PRIMARY KEY (ERROR_ID, PROCESS_ID),
  FOREIGN KEY (PROCESS_ID) REFERENCES PROCESS(PROCESS_ID) ON DELETE CASCADE
);

CREATE TABLE PROCESS_RESOURCE_SCHEDULE (
  PROCESS_ID varchar(255),
  RESOURCE_HOST_ID varchar(255),
  TOTAL_CPU_COUNT int(11),
  NODE_COUNT int(11),
  NUMBER_OF_THREADS int(11),
  QUEUE_NAME varchar(255),
  WALL_TIME_LIMIT int(11),
  TOTAL_PHYSICAL_MEMORY int(11),
  PRIMARY KEY (PROCESS_ID),
  FOREIGN KEY (PROCESS_ID) REFERENCES PROCESS(PROCESS_ID) ON DELETE CASCADE
);

CREATE TABLE TASK (
  TASK_ID varchar(255),
  TASK_TYPE varchar(255),
  PARENT_PROCESS_ID varchar(255),
  CREATION_TIME timestamp DEFAULT NOW(),
  LAST_UPDATE_TIME timestamp DEFAULT '0000-00-00 00:00:00',
  TASK_DETAIL text,
  TASK_INTERNAL_STORE tinyint(4),
  PRIMARY KEY (TASK_ID),
  FOREIGN KEY (PARENT_PROCESS_ID) REFERENCES PROCESS(PROCESS_ID) ON DELETE CASCADE
);

CREATE TABLE TASK_STATUS (
  STATUS_ID varchar(255),
  TASK_ID varchar(255),
  STATE varchar(255),
  TIME_OF_STATE_CHANGE timestamp DEFAULT '0000-00-00 00:00:00',
  REASON LONGTEXT,
  PRIMARY KEY (STATUS_ID, TASK_ID),
  FOREIGN KEY (TASK_ID) REFERENCES TASK(TASK_ID) ON DELETE CASCADE
);


CREATE TABLE TASK_ERROR (
  ERROR_ID varchar(255),
  TASK_ID varchar(255),
  CREATION_TIME timestamp DEFAULT NOW(),
  ACTUAL_ERROR_MESSAGE text,
  USER_FRIENDLY_MESSAGE text,
  TRANSIENT_OR_PERSISTENT tinyint(1),
  ROOT_CAUSE_ERROR_ID_LIST text,
  PRIMARY KEY (ERROR_ID, TASK_ID),
  FOREIGN KEY (TASK_ID) REFERENCES TASK(TASK_ID) ON DELETE CASCADE
);

CREATE TABLE JOB (
  JOB_ID varchar(255),
  TASK_ID varchar(255),
  JOB_DESCRIPTION varchar(255),
  CREATION_TIME timestamp DEFAULT NOW(),
  COMPUTE_RESOURCE_CONSUMED varchar(255),
  JOB_NAME varchar(255),
  WORKING_DIR varchar(255),
  PRIMARY KEY (JOB_ID, TASK_ID),
  FOREIGN KEY (TASK_ID) REFERENCES TASK(TASK_ID) ON DELETE CASCADE
);

CREATE TABLE JOB_STATUS (
  STATUS_ID varchar(255),
  JOB_ID varchar(255),
  TASK_ID varchar(255),
  STATE varchar(255),
  TIME_OF_STATE_CHANGE timestamp DEFAULT '0000-00-00 00:00:00',
  REASON LONGTEXT,
  PRIMARY KEY (STATUS_ID, JOB_ID, TASK_ID),
  FOREIGN KEY (JOB_ID, TASK_ID) REFERENCES JOB(JOB_ID, TASK_ID) ON DELETE CASCADE
);


CREATE TABLE CONFIGURATION
(
        CONFIG_KEY VARCHAR(255),
        CONFIG_VAL VARCHAR(255),
        EXPIRE_DATE TIMESTAMP DEFAULT '0000-00-00 00:00:00',
        CATEGORY_ID VARCHAR (255),
        PRIMARY KEY(CONFIG_KEY, CONFIG_VAL, CATEGORY_ID)
);

INSERT INTO CONFIGURATION (CONFIG_KEY, CONFIG_VAL, EXPIRE_DATE, CATEGORY_ID) VALUES('registry.version', '0.16', NOW() ,'SYSTEM');