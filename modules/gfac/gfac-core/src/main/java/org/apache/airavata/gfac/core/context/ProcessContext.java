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

import org.apache.airavata.common.utils.AiravataUtils;
import org.apache.airavata.gfac.core.GFacUtils;
import org.apache.airavata.gfac.core.cluster.RemoteCluster;
import org.apache.airavata.messaging.core.Publisher;
import org.apache.airavata.model.appcatalog.appdeployment.ApplicationDeploymentDescription;
import org.apache.airavata.model.appcatalog.appinterface.ApplicationInterfaceDescription;
import org.apache.airavata.model.appcatalog.computeresource.ComputeResourceDescription;
import org.apache.airavata.model.appcatalog.computeresource.DataMovementProtocol;
import org.apache.airavata.model.appcatalog.computeresource.JobSubmissionProtocol;
import org.apache.airavata.model.appcatalog.computeresource.MonitorMode;
import org.apache.airavata.model.appcatalog.computeresource.ResourceJobManager;
import org.apache.airavata.model.appcatalog.gatewayprofile.ComputeResourcePreference;
import org.apache.airavata.model.appcatalog.gatewayprofile.GatewayResourceProfile;
import org.apache.airavata.model.job.JobModel;
import org.apache.airavata.model.process.ProcessModel;
import org.apache.airavata.model.status.JobStatus;
import org.apache.airavata.model.status.ProcessState;
import org.apache.airavata.model.status.ProcessStatus;
import org.apache.airavata.registry.cpi.AppCatalog;
import org.apache.airavata.registry.cpi.ExperimentCatalog;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ProcessContext {

	private static final Logger log = LoggerFactory.getLogger(ProcessContext.class);
	// process model
	private ExperimentCatalog experimentCatalog;
	private AppCatalog appCatalog;
	private CuratorFramework curatorClient;
	private Publisher statusPublisher;
	private final String processId;
	private final String gatewayId;
	private final String tokenId;
	private ProcessModel processModel;
	private String workingDir;
	private String inputDir;
	private String outputDir;
	private String localWorkingDir;
	private List<TaskContext> taskChain;
	private GatewayResourceProfile gatewayResourceProfile;
	private ComputeResourceDescription computeResourceDescription;
	private ApplicationDeploymentDescription applicationDeploymentDescription;
	private ApplicationInterfaceDescription applicationInterfaceDescription;
	private RemoteCluster remoteCluster;
	private Map<String, String> sshProperties;
	private String stdoutLocation;
	private String stderrLocation;
	private JobSubmissionProtocol jobSubmissionProtocol;
	private DataMovementProtocol dataMovementProtocol;
	private JobModel jobModel;
	private ComputeResourcePreference computeResourcePreference;
	private MonitorMode monitorMode;
	private ResourceJobManager resourceJobManager;

	/**
	 * Note: process context property use lazy loading approach. In runtime you will see some properties as null
	 * unless you have access it previously. Once that property access using the api,it will be set to correct value.
	 */
	public ProcessContext(String processId, String gatewayId, String tokenId) {
		this.processId = processId;
		this.gatewayId = gatewayId;
		this.tokenId = tokenId;
	}


	public ExperimentCatalog getExperimentCatalog() {
		return experimentCatalog;
	}

	public void setExperimentCatalog(ExperimentCatalog experimentCatalog) {
		this.experimentCatalog = experimentCatalog;
	}

	public AppCatalog getAppCatalog() {
		return appCatalog;
	}

	public void setAppCatalog(AppCatalog appCatalog) {
		this.appCatalog = appCatalog;
	}

	public String getGatewayId() {
		return gatewayId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public String getProcessId() {
		return processId;
	}

	public CuratorFramework getCuratorClient() {
		return curatorClient;
	}

	public void setCuratorClient(CuratorFramework curatorClient) {
		this.curatorClient = curatorClient;
	}

	public Publisher getStatusPublisher() {
		return statusPublisher;
	}

	public void setStatusPublisher(Publisher statusPublisher) {
		this.statusPublisher = statusPublisher;
	}

	public ProcessModel getProcessModel() {
		return processModel;
	}

	public void setProcessModel(ProcessModel processModel) {
		this.processModel = processModel;
	}

	public String getWorkingDir() {
		if (workingDir == null) {
			String scratchLocation = computeResourcePreference.getScratchLocation();
			workingDir = (scratchLocation.endsWith("/") ? scratchLocation + processId : scratchLocation + "/" +
					processId);
		}
		return workingDir;
	}

	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}

	public List<TaskContext> getTaskChain() {
		return taskChain;
	}

	public void setTaskChain(List<TaskContext> taskChain) {
		this.taskChain = taskChain;
	}

	public GatewayResourceProfile getGatewayResourceProfile() {
		return gatewayResourceProfile;
	}

	public void setGatewayResourceProfile(GatewayResourceProfile gatewayResourceProfile) {
		this.gatewayResourceProfile = gatewayResourceProfile;
	}

	public RemoteCluster getRemoteCluster() {
		return remoteCluster;
	}

	public void setRemoteCluster(RemoteCluster remoteCluster) {
		this.remoteCluster = remoteCluster;
	}

	public Map<String, String> getSshProperties() {
		return sshProperties;
	}

	public void setSshProperties(Map<String, String> sshProperties) {
		this.sshProperties = sshProperties;
	}

	public ComputeResourceDescription getComputeResourceDescription() {
		return computeResourceDescription;
	}

	public void setComputeResourceDescription(ComputeResourceDescription computeResourceDescription) {
		this.computeResourceDescription = computeResourceDescription;
	}

	public ApplicationDeploymentDescription getApplicationDeploymentDescription() {
		return applicationDeploymentDescription;
	}

	public void setApplicationDeploymentDescription(ApplicationDeploymentDescription
			                                                applicationDeploymentDescription) {
		this.applicationDeploymentDescription = applicationDeploymentDescription;
	}

	public ApplicationInterfaceDescription getApplicationInterfaceDescription() {
		return applicationInterfaceDescription;
	}

	public void setApplicationInterfaceDescription(ApplicationInterfaceDescription applicationInterfaceDescription) {
		this.applicationInterfaceDescription = applicationInterfaceDescription;
	}

	public String getStdoutLocation() {
		return stdoutLocation;
	}

	public void setStdoutLocation(String stdoutLocation) {
		this.stdoutLocation = stdoutLocation;
	}

	public String getStderrLocation() {
		return stderrLocation;
	}

	public void setStderrLocation(String stderrLocation) {
		this.stderrLocation = stderrLocation;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public String getOutputDir() {
		if (outputDir == null) {
			outputDir = getWorkingDir();
		}
		return outputDir;
	}

	public String getInputDir() {
		if (inputDir == null) {
			inputDir = getWorkingDir();
		}
		return inputDir;
	}

	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	public JobSubmissionProtocol getJobSubmissionProtocol() {
		if (jobSubmissionProtocol == null) {
			jobSubmissionProtocol = computeResourcePreference.getPreferredJobSubmissionProtocol();
		}
		return jobSubmissionProtocol;
	}

	public void setJobSubmissionProtocol(JobSubmissionProtocol jobSubmissionProtocol) {
		this.jobSubmissionProtocol = jobSubmissionProtocol;
	}

	public DataMovementProtocol getDataMovementProtocol() {
		if (dataMovementProtocol == null) {
			dataMovementProtocol = computeResourcePreference.getPreferredDataMovementProtocol();
		}
		return dataMovementProtocol;
	}

	public void setDataMovementProtocol(DataMovementProtocol dataMovementProtocol) {
		this.dataMovementProtocol = dataMovementProtocol;
	}

	public JobModel getJobModel() {
		if (jobModel == null) {
			jobModel = new JobModel();
			jobModel.setWorkingDir(getWorkingDir());
			jobModel.setCreationTime(AiravataUtils.getCurrentTimestamp().getTime());
		}
		return jobModel;
	}

	public void setJobModel(JobModel jobModel) {
		this.jobModel = jobModel;
	}

	public ComputeResourcePreference getComputeResourcePreference() {
		return computeResourcePreference;
	}

	public void setComputeResourcePreference(ComputeResourcePreference computeResourcePreference) {
		this.computeResourcePreference = computeResourcePreference;
	}

	public ProcessState getProcessState() {
		return processModel.getProcessStatus().getState();
	}

	public void setProcessStatus(ProcessStatus status) {
		if (status != null) {
			log.info("expId: {}, processId: {} :- Status changed {} -> {}", getExperimentId(), processId,
					getProcessState().name(), status.getState().name());
			processModel.setProcessStatus(status);
		}
	}

	public ProcessStatus getProcessStatus(){
		return processModel.getProcessStatus();
	}

	public String getComputeResourceId() {
		return getComputeResourceDescription().getComputeResourceId();
	}

	public void setMonitorMode(MonitorMode monitorMode) {
		this.monitorMode = monitorMode;
	}

	public MonitorMode getMonitorMode() {
		return monitorMode;
	}

	public void setResourceJobManager(ResourceJobManager resourceJobManager) {
		this.resourceJobManager = resourceJobManager;
	}

	public ResourceJobManager getResourceJobManager() {
		return resourceJobManager;
	}

	public String getLocalWorkingDir() {
		return localWorkingDir;
	}

	public void setLocalWorkingDir(String localWorkingDir) {
		this.localWorkingDir = localWorkingDir;
	}

	public String getExperimentId() {
		return processModel.getExperimentId();
	}
}
