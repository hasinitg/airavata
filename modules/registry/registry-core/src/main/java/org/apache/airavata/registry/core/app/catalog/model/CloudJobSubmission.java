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
package org.apache.airavata.registry.core.app.catalog.model;

import org.apache.openjpa.persistence.DataCache;

import javax.persistence.*;
import java.io.Serializable;

@DataCache
@Entity
@Table(name = "CLOUD_JOB_SUBMISSION")
public class CloudJobSubmission implements Serializable {
    @Id
    @Column(name = "JOB_SUBMISSION_INTERFACE_ID")
    private String jobSubmissionInterfaceId;

    @Column(name = "SECURITY_PROTOCOL")
    private String securityProtocol;

    @Column(name = "NODE_ID")
    private String nodeId;

    @Column(name = "EXECUTABLE_TYPE")
    private String executableType;

    @Column(name = "PROVIDER_NAME")
    private String providerName;

    @Column(name = "USER_ACCOUNT_NAME")
    private String userAccountName;


    public String getExecutableType() {
        return executableType;
    }

    public void setExecutableType(String executableType) {
        this.executableType = executableType;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getJobSubmissionInterfaceId() {
        return jobSubmissionInterfaceId;
    }


    public String getSecurityProtocol() {
        return securityProtocol;
    }


    public void setJobSubmissionInterfaceId(String jobSubmissionInterfaceId) {
        this.jobSubmissionInterfaceId=jobSubmissionInterfaceId;
    }


    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol=securityProtocol;
    }
}
