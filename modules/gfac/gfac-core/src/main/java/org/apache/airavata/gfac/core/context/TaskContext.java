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
package org.apache.airavata.gfac.core.context;

import org.apache.airavata.model.status.TaskState;
import org.apache.airavata.model.status.TaskStatus;
import org.apache.airavata.model.task.TaskModel;
import org.apache.airavata.model.task.TaskTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskContext {
	private static final Logger log = LoggerFactory.getLogger(TaskContext.class);

	private TaskModel taskModel;
	private ProcessContext parentProcessContext;

	public TaskModel getTaskModel() {
		return taskModel;
	}

	public void setTaskModel(TaskModel taskModel) {
		this.taskModel = taskModel;
	}

	public ProcessContext getParentProcessContext() {
		return parentProcessContext;
	}

	public void setParentProcessContext(ProcessContext parentProcessContext) {
		this.parentProcessContext = parentProcessContext;
	}

	public String getWorkingDir() {
		return getParentProcessContext().getWorkingDir();
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		log.info("expId: {}, processId: {}, taskId: {}, type: {}:- Status changed {} -> {}", parentProcessContext
				.getExperimentId(), parentProcessContext.getProcessId(), getTaskId(), getTaskType().name(),
				getTaskState().name(), taskStatus .getState().name());
		taskModel.setTaskStatus(taskStatus);
	}

	public TaskStatus getTaskStatus() {
		return taskModel.getTaskStatus();
	}

	public TaskState getTaskState() {
		return taskModel.getTaskStatus().getState();
	}

	public TaskTypes getTaskType() {
		return taskModel.getTaskType();
	}

	public String getTaskId() {
		return taskModel.getTaskId();
	}

	public String getLocalWorkingDir() {
		return getParentProcessContext().getLocalWorkingDir();
	}
}
