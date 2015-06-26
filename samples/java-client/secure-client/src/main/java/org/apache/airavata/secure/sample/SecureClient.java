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
package org.apache.airavata.secure.sample;

import org.apache.airavata.api.client.AiravataClientFactory;
import org.apache.airavata.model.error.*;
import org.apache.airavata.api.Airavata;
import org.apache.airavata.model.security.AuthzToken;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.identity.oauth.stub.dto.OAuthConsumerAppDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SecureClient {
    private static Logger logger = LoggerFactory.getLogger(SecureClient.class);

    public static void main(String[] args) /*throws Exception*/ {
        //register OAuth application - this happens once during initialization of the gateway.

        /************************Start obtaining input from user*****************************/
        System.out.println("");
        System.out.println("Registering OAuth application representing the client....");
        System.out.println("Please enter following information as you prefer, or use defaults.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("OAuth application name: (default:" + Properties.appName +
                ", press 'd' to use default value.)");
        String appNameInput = scanner.next();
        String appName = null;
        if (appNameInput.trim().equals("d")) {
            appName = Properties.appName;
        } else {
            appName = appNameInput.trim();
        }

        System.out.println("Consumer Id: (default:" + Properties.consumerID + ", press 'd' to use default value.)");
        String consumerIdInput = scanner.next();
        String consumerId = null;
        if (consumerIdInput.trim().equals("d")) {
            consumerId = Properties.consumerID;
        } else {
            consumerId = consumerIdInput.trim();
        }

        System.out.println("Consumer Secret: (default:" + Properties.consumerSecret +
                ", press 'd' to use default value.)");
        String consumerSecInput = scanner.next();
        String consumerSecret = null;
        if (consumerSecInput.trim().equals("d")) {
            consumerSecret = Properties.consumerSecret;
        } else {
            consumerSecret = consumerSecInput.trim();
        }
        /***************************** Finish obtaining input from user*******************************************/

        /*********************** Perform registration of the client as an OAuth app***************************/
        try {
            ConfigurationContext configContext =
                    ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
            OAuthAppRegisteringClient authAppRegisteringClient = new OAuthAppRegisteringClient(
                    Properties.oauthAuthzServerURL, Properties.adminUserName, Properties.adminPassword, configContext);
            OAuthConsumerAppDTO appDTO = authAppRegisteringClient.registerApplication(appName, consumerId, consumerSecret);
            /********************* Complete registering the client ***********************************************/
            System.out.println("");
            System.out.println("Registered OAuth app successfully. Following is app's details:");
            System.out.println("App Name: " + appDTO.getApplicationName());
            System.out.println("Consumer ID: " + appDTO.getOauthConsumerKey());
            System.out.println("Consumer Secret: " + appDTO.getOauthConsumerSecret());
            System.out.println("");
            //obtain OAuth access token

            /************************Start obtaining input from user*****************************/
            System.out.println("Please select the preferred grant type: (or press d to use the default option" + Properties.grantType + ")");
            System.out.println("1. Resource Owner Password Credential.");
            System.out.println("2. Client Credential.");

            String grantTypeInput = scanner.next().trim();
            int grantType = 0;
            if (grantTypeInput.equals("d")) {
                grantType = Properties.grantType;
            } else {
                grantType = Integer.valueOf(grantTypeInput);
            }
            String userName = null;
            String password = null;
            if (grantType == 1) {
                System.out.println("Obtaining OAuth access token via 'Resource Owner Password' grant type....");
                System.out.println("Please enter following information as you prefer, or use defaults.");
                System.out.println("End user's name: (default:" + Properties.userName +
                        ", press 'd' to use default value.)");
                String userNameInput = scanner.next();
                if (userNameInput.trim().equals("d")) {
                    userName = Properties.userName;
                } else {
                    userName = userNameInput.trim();
                }

                System.out.println("End user's password: (default:" + Properties.password + ", press 'd' to use default value.)");
                String passwordInput = scanner.next();
                if (passwordInput.trim().equals("d")) {
                    password = Properties.password;
                } else {
                    password = passwordInput.trim();
                }
            } else if (grantType == 2) {
                System.out.println("Obtaining OAuth access token via 'Client Credential' grant type...' grant type....");
            }

            /***************************** Finish obtaining input from user*******************************************/

            //obtain the OAuth token for the specified end user.
            String accessToken = new OAuthTokenRetrievalClient().retrieveAccessToken(consumerId, consumerSecret,
                    userName, password, grantType);
            System.out.println("OAuth access token is: " + accessToken);
            System.out.println("");

            //invoke Airavata API by the SecureClient, on behalf of the user.
            System.out.println("Invoking Airavata API...");
            System.out.println("Enter the access token to be used: (default:" + accessToken + ", press 'd' to use default value.)");
            String accessTokenInput = scanner.next();
            String acTk = null;
            if (accessTokenInput.trim().equals("d")) {
                acTk = accessToken;
            } else {
                acTk = accessTokenInput.trim();
            }

            Airavata.Client client = createAiravataClient(Properties.SERVER_HOST, Properties.SERVER_PORT);
            AuthzToken authzToken = new AuthzToken();
            authzToken.setAccessToken(acTk);
            Map<String, String> claimsMap = new HashMap<>();
            claimsMap.put("userName", "hasinitg");
            claimsMap.put("email", "hasini@gmail.com");
            authzToken.setClaimsMap(claimsMap);
            String version = client.getAPIVersion(authzToken);
            System.out.println("Airavata API version: " + version);
            System.out.println("");

        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } catch (AiravataClientConnectException e) {
            e.printStackTrace();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (AiravataSecurityException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Airavata.Client createAiravataClient(String serverHost, int serverPort) throws
            AiravataClientConnectException {
        try {
            //Airavata.Client client = AiravataClientFactory.createAiravataClient(serverHost, serverPort);
            Airavata.Client client = AiravataClientFactory.createAiravataSecureClient(serverHost, serverPort,
                    Properties.TRUST_STORE_PATH, Properties.TRUST_STORE_PASSWORD, 10000);
            return client;

        } catch (AiravataClientConnectException e) {
            logger.error("Error while creating Airavata Client.");
            throw e;
        }
    }
}
