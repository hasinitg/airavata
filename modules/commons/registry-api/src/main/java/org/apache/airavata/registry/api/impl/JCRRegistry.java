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

package org.apache.airavata.registry.api.impl;

import java.lang.reflect.Constructor;
import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.TimeZone;

import javax.jcr.Credentials;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.RepositoryFactory;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Value;
import javax.xml.namespace.QName;

import org.apache.airavata.registry.api.Axis2Registry;
import org.apache.airavata.registry.api.DataRegistry;
import org.apache.airavata.registry.api.exception.DeploymentDescriptionRetrieveException;
import org.apache.airavata.registry.api.exception.HostDescriptionRetrieveException;
import org.apache.airavata.registry.api.exception.RegistryException;
import org.apache.airavata.registry.api.exception.ServiceDescriptionRetrieveException;
import org.apache.airavata.registry.api.user.UserManager;
import org.apache.airavata.registry.api.util.WebServiceUtil;
import org.apache.airavata.schemas.gfac.ApplicationDeploymentDescriptionDocument;
import org.apache.airavata.schemas.gfac.HostDescriptionDocument;
import org.apache.airavata.schemas.gfac.Parameter;
import org.apache.airavata.schemas.gfac.ServiceDescriptionDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JCRRegistry extends Observable implements Axis2Registry,
		DataRegistry {

	private static final String OUTPUT_NODE_NAME = "OUTPUTS";
	private static final String SERVICE_NODE_NAME = "SERVICE_HOST";
	private static final String GFAC_INSTANCE_DATA = "GFAC_INSTANCE_DATA";
	private static final String DEPLOY_NODE_NAME = "APP_HOST";
	private static final String HOST_NODE_NAME = "GFAC_HOST";
	private static final String XML_PROPERTY_NAME = "XML";
	private static final String WSDL_PROPERTY_NAME = "WSDL";
	private static final String GFAC_URL_PROPERTY_NAME = "GFAC_URL_LIST";
	private static final String LINK_NAME = "LINK";
	public static final String WORKFLOWS = "WORKFLOWS";
	public static final String PUBLIC = "PUBLIC";
	public static final String REGISTRY_TYPE_WORKFLOW = "workflow";
	public static final int GFAC_URL_UPDATE_INTERVAL = 1000 * 60 * 60 * 3;
	public static final String WORKFLOW_DATA = "WorkflowData";

	private Repository repository;
	private Credentials credentials;
	private UserManager userManager;
	private String username;
	private URI repositoryURI;

	private static Logger log = LoggerFactory.getLogger(JCRRegistry.class);

	public JCRRegistry(URI repositoryURI, String className, String user,
			String pass, Map<String, String> map) throws RepositoryException {
		try {
			/*
			 * Load the configuration from properties file at this level and
			 * create the object
			 */
			Class registryRepositoryFactory = Class.forName(className);
			Constructor c = registryRepositoryFactory.getConstructor();
			RepositoryFactory repositoryFactory = (RepositoryFactory) c
					.newInstance();
			setRepositoryURI(repositoryURI);
			repository = repositoryFactory.getRepository(map);
			setUsername(user);
			credentials = new SimpleCredentials(getUsername(),
					new String(pass).toCharArray());
		} catch (ClassNotFoundException e) {
			log.error("Error class path settting", e);
		} catch (RepositoryException e) {
			log.error("Error connecting Remote Registry instance", e);
			throw e;
		} catch (Exception e) {
			log.error("Error init", e);
		}
	}

	public JCRRegistry(Repository repo, Credentials credentials) {
		this.repository = repo;
		this.credentials = credentials;
	}

	public Session getSession() throws RepositoryException {
		return repository.login(credentials);
	}

	private Node getServiceNode(Session session) throws RepositoryException {
		return getOrAddNode(session.getRootNode(), SERVICE_NODE_NAME);
	}

	private Node getDeploymentNode(Session session) throws RepositoryException {
		return getOrAddNode(session.getRootNode(), DEPLOY_NODE_NAME);
	}

	private Node getHostNode(Session session) throws RepositoryException {
		return getOrAddNode(session.getRootNode(), HOST_NODE_NAME);
	}

	private Node getOrAddNode(Node node, String name)
			throws RepositoryException {
		Node node1 = null;
		try {
			node1 = node.getNode(name);
		} catch (PathNotFoundException pnfe) {
			node1 = node.addNode(name);
		} catch (RepositoryException e) {
			String msg = "failed to resolve the path of the given node ";
			log.debug(msg);
			throw new RepositoryException(msg, e);
		}
		return node1;
	}

	private void closeSession(Session session) {
		if (session != null && session.isLive()) {
			session.logout();
		}
	}

	public List<HostDescriptionDocument> getServiceLocation(String serviceId) {
		Session session = null;
		ArrayList<HostDescriptionDocument> result = new ArrayList<HostDescriptionDocument>();
		try {
			session = getSession();
			Node node = getServiceNode(session);
			Node serviceNode = node.getNode(serviceId);
			if (serviceNode.hasProperty(LINK_NAME)) {
				Property prop = serviceNode.getProperty(LINK_NAME);
				Value[] vals = prop.getValues();
				for (Value val : vals) {
					Node host = session.getNodeByIdentifier(val.getString());
					Property hostProp = host.getProperty(XML_PROPERTY_NAME);
					result.add(HostDescriptionDocument.Factory.parse(hostProp
							.getString()));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public void deleteServiceDescription(String serviceId)
			throws ServiceDescriptionRetrieveException {
		Session session = null;
		try {
			session = getSession();
			Node serviceNode = getServiceNode(session);
			Node node = serviceNode.getNode(serviceId);
			if (node != null) {
				node.remove();
				session.save();
			}
		} catch (Exception e) {
			throw new ServiceDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
	}

	public ServiceDescriptionDocument getServiceDescription(String serviceId)
			throws ServiceDescriptionRetrieveException {
		Session session = null;
		ServiceDescriptionDocument result = null;
		try {
			session = getSession();
			Node serviceNode = getServiceNode(session);
			Node node = serviceNode.getNode(serviceId);
			Property prop = node.getProperty(XML_PROPERTY_NAME);
			result = ServiceDescriptionDocument.Factory.parse(prop.getString());
		} catch (Exception e) {
			throw new ServiceDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	public ApplicationDeploymentDescriptionDocument getDeploymentDescription(
			String serviceId, String hostId) throws RegistryException {
		Session session = null;
		ApplicationDeploymentDescriptionDocument result = null;
		try {
			session = getSession();
			Node deploymentNode = getDeploymentNode(session);
			Node serviceNode = deploymentNode.getNode(serviceId);
			Node hostNode = serviceNode.getNode(hostId);
			NodeIterator nodes = hostNode.getNodes();
			for (; nodes.hasNext();) {
				Node app = nodes.nextNode();
				Property prop = app.getProperty(XML_PROPERTY_NAME);
				result = ApplicationDeploymentDescriptionDocument.Factory.parse(prop
						.getString());
			}
		} catch (Exception e) {
			log.error("Cannot get Deployment Description", e);
			throw new DeploymentDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	public void deleteHostDescription(String hostId) throws RegistryException {
		Session session = null;
		try {
			session = getSession();
			Node hostNode = getHostNode(session);
			Node node = hostNode.getNode(hostId);
			if (node != null) {
				node.remove();
				session.save();
			}
		} catch (Exception e) {
			throw new HostDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
	}

	public HostDescriptionDocument getHostDescription(String hostId)
			throws RegistryException {
		Session session = null;
		HostDescriptionDocument result = null;
		try {
			session = getSession();
			Node hostNode = getHostNode(session);
			Node node = hostNode.getNode(hostId);
			if (node != null) {
				result = getHostDescriptor(node);
			}
		} catch (Exception e) {
			throw new HostDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	private HostDescriptionDocument getHostDescriptor(Node node)
			throws RegistryException {
		HostDescriptionDocument result;
		try {			
			Property prop = node.getProperty(XML_PROPERTY_NAME);
			result = HostDescriptionDocument.Factory.parse(prop.getString());
		} catch (Exception e) {
			throw new HostDescriptionRetrieveException(e);
		}
		return result;
	}

	public String saveHostDescription(HostDescriptionDocument host) {
		Session session = null;
		String result = null;
		try {
			session = getSession();
			Node hostNode = getHostNode(session);
			Node node = getOrAddNode(hostNode, host.getHostDescription().getName());
			node.setProperty(XML_PROPERTY_NAME, host.xmlText());
			session.save();

			result = node.getIdentifier();
			triggerObservers(this);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public String saveServiceDescription(ServiceDescriptionDocument service) {
		Session session = null;
		String result = null;
		try {
			session = getSession();
			Node serviceNode = getServiceNode(session);
			Node node = getOrAddNode(serviceNode, service.getServiceDescription().getName());
			node.setProperty(XML_PROPERTY_NAME, service.xmlText());
			session.save();

			result = node.getIdentifier();
			triggerObservers(this);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public String saveDeploymentDescription(String serviceId, String hostId,
			ApplicationDeploymentDescriptionDocument app) {
		Session session = null;
		String result = null;
		try {
			session = getSession();
			Node deployNode = getDeploymentNode(session);
			Node serviceNode = getOrAddNode(deployNode, serviceId);
			Node hostNode = getOrAddNode(serviceNode, hostId);
			Node appName = getOrAddNode(hostNode, app.getApplicationDeploymentDescription().getName());
			appName.setProperty(XML_PROPERTY_NAME, app.xmlText());
			session.save();

			result = appName.getIdentifier();
			triggerObservers(this);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public boolean deployServiceOnHost(String serviceId, String hostId) {
		Session session = null;
		try {
			session = getSession();
			Node serviceRoot = getServiceNode(session);
			Node hostRoot = getHostNode(session);

			Node serviceNode = serviceRoot.getNode(serviceId);
			Node hostNode = hostRoot.getNode(hostId);

			if (!serviceNode.hasProperty(LINK_NAME)) {
				serviceNode.setProperty(LINK_NAME,
						new String[] { hostNode.getIdentifier() });
			} else {
				Property prop = serviceNode.getProperty(LINK_NAME);
				Value[] vals = prop.getValues();
				ArrayList<String> s = new ArrayList<String>();
				for (Value val : vals) {
					s.add(val.getString());
				}

				if (s.contains(hostNode.getIdentifier())) {
					return false;
				}

				s.add(hostNode.getIdentifier());
				serviceNode.setProperty(LINK_NAME, s.toArray(new String[0]));
			}

			session.save();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return false;
	}

	public List<ServiceDescriptionDocument> searchServiceDescription(String name)
			throws RegistryException {
		Session session = null;
		ArrayList<ServiceDescriptionDocument> result = new ArrayList<ServiceDescriptionDocument>();
		try {
			session = getSession();
			Node node = getServiceNode(session);
			NodeIterator nodes = node.getNodes();
			for (; nodes.hasNext();) {
				Node service = nodes.nextNode();
				Property prop = service.getProperty(XML_PROPERTY_NAME);
				result.add(ServiceDescriptionDocument.Factory.parse(prop.getString()));
			}
		} catch (Exception e) {
			new ServiceDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	public List<HostDescriptionDocument> searchHostDescription(String nameRegEx)
			throws RegistryException {
		Session session = null;
		List<HostDescriptionDocument> result = new ArrayList<HostDescriptionDocument>();
		try {
			session = getSession();
			Node node = getHostNode(session);
			NodeIterator nodes = node.getNodes();
			for (; nodes.hasNext();) {
				Node host = nodes.nextNode();
				if (host != null && host.getName().matches(nameRegEx)) {
					HostDescriptionDocument hostDescriptor = getHostDescriptor(host);
					result.add(hostDescriptor);
				}
			}
		} catch (Exception e) {
			throw new HostDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	public Map<ApplicationDeploymentDescriptionDocument, String> searchDeploymentDescription()
			throws RegistryException {
		Session session = null;
		Map<ApplicationDeploymentDescriptionDocument, String> result = new HashMap<ApplicationDeploymentDescriptionDocument, String>();
		try {
			session = getSession();
			Node deploymentNode = getDeploymentNode(session);
			NodeIterator serviceNodes = deploymentNode.getNodes();

			for (; serviceNodes.hasNext();) {
				Node serviceNode = serviceNodes.nextNode();
				NodeIterator hostNodes = serviceNode.getNodes();

				for (; hostNodes.hasNext();) {
					Node hostNode = hostNodes.nextNode();
					NodeIterator nodes = hostNode.getNodes();
					for (; nodes.hasNext();) {
						Node app = nodes.nextNode();
						Property prop = app.getProperty(XML_PROPERTY_NAME);
						result.put(ApplicationDeploymentDescriptionDocument.Factory
								.parse(prop.getString()), serviceNode.getName()
								+ "$" + hostNode.getName());
					}
				}
			}
		} catch (Exception e) {
			throw new DeploymentDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	public void deleteDeploymentDescription(String serviceName,
			String hostName, String applicationName)
			throws RegistryException {
		Session session = null;
		try {
			session = getSession();
			Node deploymentNode = getDeploymentNode(session);
			Node serviceNode = deploymentNode.getNode(serviceName);
			Node hostNode = serviceNode.getNode(hostName);
			NodeIterator nodes = hostNode.getNodes();
			for (; nodes.hasNext();) {
				Node app = nodes.nextNode();
				Property prop = app.getProperty(XML_PROPERTY_NAME);
				ApplicationDeploymentDescriptionDocument appDesc = ApplicationDeploymentDescriptionDocument.Factory
						.parse(prop.getString());
				if (appDesc.getApplicationDeploymentDescription().getName().matches(applicationName)) {
					app.remove();
				}
			}
			session.save();
		} catch (Exception e) {
			throw new DeploymentDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<ApplicationDeploymentDescriptionDocument> searchDeploymentDescription(
			String serviceName, String hostName, String applicationName)
			throws RegistryException {
		Session session = null;
		List<ApplicationDeploymentDescriptionDocument> result = new ArrayList<ApplicationDeploymentDescriptionDocument>();
		try {
			session = getSession();
			Node deploymentNode = getDeploymentNode(session);
			Node serviceNode = deploymentNode.getNode(serviceName);
			Node hostNode = serviceNode.getNode(hostName);
			NodeIterator nodes = hostNode.getNodes();
			for (; nodes.hasNext();) {
				Node app = nodes.nextNode();
				Property prop = app.getProperty(XML_PROPERTY_NAME);
				ApplicationDeploymentDescriptionDocument appDesc = ApplicationDeploymentDescriptionDocument.Factory
						.parse(prop.getString());
				if (appDesc.getApplicationDeploymentDescription().getName().matches(applicationName)) {
					result.add(appDesc);
				}
			}
		} catch (Exception e) {
			throw new DeploymentDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	public List<ApplicationDeploymentDescriptionDocument> searchDeploymentDescription(
			String serviceName, String hostName) throws RegistryException {
		Session session = null;
		List<ApplicationDeploymentDescriptionDocument> result = new ArrayList<ApplicationDeploymentDescriptionDocument>();
		try {
			session = getSession();
			Node deploymentNode = getDeploymentNode(session);
			Node serviceNode = deploymentNode.getNode(serviceName);
			Node hostNode = serviceNode.getNode(hostName);
			NodeIterator nodes = hostNode.getNodes();
			for (; nodes.hasNext();) {
				Node app = nodes.nextNode();
				Property prop = app.getProperty(XML_PROPERTY_NAME);
				result.add(ApplicationDeploymentDescriptionDocument.Factory.parse(prop
						.getString()));
			}
		} catch (Exception e) {
			throw new DeploymentDescriptionRetrieveException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	public String saveWSDL(ServiceDescriptionDocument service, String WSDL) {
		Session session = null;
		String result = null;
		try {
			session = getSession();
			Node serviceNode = getServiceNode(session);
			Node node = getOrAddNode(serviceNode, service.getServiceDescription().getName());
			node.setProperty(WSDL_PROPERTY_NAME, WSDL);
			session.save();

			result = node.getIdentifier();
			triggerObservers(this);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public String saveWSDL(ServiceDescriptionDocument service) {
		return saveWSDL(service, WebServiceUtil.generateWSDL(service));
	}

	public String getWSDL(String serviceName) {
		Session session = null;
		String result = null;
		try {
			session = getSession();
			Node serviceNode = getServiceNode(session);
			Node node = serviceNode.getNode(serviceName);
			Property prop = node.getProperty(WSDL_PROPERTY_NAME);
			result = prop.getString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public boolean saveGFacDescriptor(String gfacURL) {
		java.util.Date today = Calendar
				.getInstance(TimeZone.getTimeZone("GMT")).getTime();
		Timestamp timestamp = new Timestamp(today.getTime());
		Session session = null;
		try {
			URI uri = new URI(gfacURL);
			String propertyName = uri.getHost() + "-" + uri.getPort();
			session = getSession();
			Node gfacDataNode = getOrAddNode(session.getRootNode(),
					GFAC_INSTANCE_DATA);
			try {
				Property prop = gfacDataNode.getProperty(propertyName);
				prop.setValue(gfacURL + ";" + timestamp.getTime());
				session.save();
			} catch (PathNotFoundException e) {
				gfacDataNode.setProperty(propertyName, gfacURL + ";"
						+ timestamp.getTime());
				session.save();
			}
			triggerObservers(this);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return true;
	}

	public boolean deleteGFacDescriptor(String gfacURL) {
		Session session = null;
		try {
			URI uri = new URI(gfacURL);
			String propertyName = uri.getHost() + "-" + uri.getPort();
			session = getSession();
			Node gfacDataNode = getOrAddNode(session.getRootNode(),
					GFAC_INSTANCE_DATA);
			Property prop = gfacDataNode.getProperty(propertyName);
			prop.setValue((String) null);
			session.save();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return true;
	}

	public List<String> getGFacDescriptorList() {
		Session session = null;
		List<String> urlList = new ArrayList<String>();
		java.util.Date today = Calendar
				.getInstance(TimeZone.getTimeZone("GMT")).getTime();
		Timestamp timestamp = new Timestamp(today.getTime());
		try {
			session = getSession();
			Node gfacNode = getOrAddNode(session.getRootNode(),
					GFAC_INSTANCE_DATA);
			PropertyIterator propertyIterator = gfacNode.getProperties();
			while (propertyIterator.hasNext()) {
				Property property = propertyIterator.nextProperty();
				if (!"nt:unstructured".equals(property.getString())) {
					String x = property.getString();
					Timestamp setTime = new Timestamp(new Long(property
							.getString().split(";")[1]));
					if (GFAC_URL_UPDATE_INTERVAL > (timestamp.getTime() - setTime
							.getTime())) {
						urlList.add(property.getString().split(";")[0]);
					}
				}
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return urlList;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String saveOutput(String workflowId, List<Parameter> parameters) {
		Session session = null;
		String result = null;
		try {
			session = getSession();
			Node outputNode = getOrAddNode(session.getRootNode(),
					OUTPUT_NODE_NAME);
			Node node = getOrAddNode(outputNode, workflowId);
			for (int i = 0; i < parameters.size(); i++) {
				node.setProperty(String.valueOf(i), parameters.get(i).xmlText());
			}

			session.save();

			result = node.getIdentifier();
			triggerObservers(this);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public List<Parameter> loadOutput(String workflowId) {
		Session session = null;
		ArrayList<Parameter> result = new ArrayList<Parameter>();
		try {
			session = getSession();
			Node outputNode = getOrAddNode(session.getRootNode(),
					OUTPUT_NODE_NAME);
			Node node = outputNode.getNode(workflowId);

			PropertyIterator it = node.getProperties();
			while (it.hasNext()) {
				Property prop = (Property) it.next();
				result.add(Parameter.Factory.parse(prop.getString()));
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO propagate
		} finally {
			closeSession(session);
		}
		return result;
	}

	public Map<QName, Node> getWorkflows(String userName) {
		Session session = null;
		Map<QName, Node> workflowList = new HashMap<QName, Node>();
		try {
			session = getSession();
			Node workflowListNode = getOrAddNode(
					getOrAddNode(session.getRootNode(), WORKFLOWS), PUBLIC);
			NodeIterator iterator = workflowListNode.getNodes();
			while (iterator.hasNext()) {
				Node nextNode = iterator.nextNode();
				workflowList.put(new QName(nextNode.getName()), nextNode);
			}
			workflowListNode = getOrAddNode(
					getOrAddNode(session.getRootNode(), WORKFLOWS), userName);
			iterator = workflowListNode.getNodes();
			while (iterator.hasNext()) {
				Node nextNode = iterator.nextNode();
				workflowList.put(new QName(nextNode.getName()), nextNode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return workflowList;
	}

	public Node getWorkflow(QName templateID, String userName) {
		Session session = null;
		Node result = null;
		try {
			session = getSession();
			Node workflowListNode = getOrAddNode(
					getOrAddNode(session.getRootNode(), WORKFLOWS), userName);
			result = getOrAddNode(workflowListNode, templateID.getLocalPart());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean saveWorkflow(QName ResourceID, String workflowName,
			String resourceDesc, String workflowAsaString, String owner,
			boolean isMakePublic) {
		Session session = null;
		try {
			session = getSession();
			Node workflowListNode = getOrAddNode(session.getRootNode(),
					WORKFLOWS);
			Node workflowNode = null;
			if (isMakePublic) {
				workflowNode = getOrAddNode(
						getOrAddNode(workflowListNode, PUBLIC), workflowName);
			} else {
				workflowNode = getOrAddNode(
						getOrAddNode(workflowListNode, owner), workflowName);
			}
			workflowNode.setProperty("workflow", workflowAsaString);
			workflowNode.setProperty("Prefix", ResourceID.getPrefix());
			workflowNode.setProperty("LocalPart", ResourceID.getLocalPart());
			workflowNode.setProperty("NamespaceURI",
					ResourceID.getNamespaceURI());
			workflowNode.setProperty("public", isMakePublic);
			workflowNode.setProperty("Description", resourceDesc);
			workflowNode.setProperty("Type", REGISTRY_TYPE_WORKFLOW);
			session.save();
			triggerObservers(this);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
			return true;
		}
	}

	public boolean deleteWorkflow(QName resourceID, String userName) {
		Session session = null;
		try {
			session = getSession();
			Node workflowListNode = getOrAddNode(
					getOrAddNode(session.getRootNode(), WORKFLOWS), userName);
			Node result = getOrAddNode(workflowListNode,
					resourceID.getLocalPart());
			result.remove();
			session.save();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public URI getRepositoryURI() {
		return repositoryURI;
	}

	private void setRepositoryURI(URI repositoryURI) {
		this.repositoryURI = repositoryURI;
	}

	protected void triggerObservers(Object o) {
		setChanged();
		notifyObservers(o);
	}

	public String getName() {
		return repository.getDescriptor(Repository.REP_NAME_DESC);
	}

	public boolean saveWorkflowData(String data, String experimentId,
			String nodeId) {
		Session session = null;
		try {
			session = getSession();
			Node workflowDataNode = getOrAddNode(
					getOrAddNode(
							getOrAddNode(session.getRootNode(), WORKFLOW_DATA),
							experimentId), nodeId);
			workflowDataNode.setProperty("content", data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
			return true;
		}

	}
}
