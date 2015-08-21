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
package org.apache.airavata.web.sample;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import java.io.IOException;

/**
 * This servlets receives and processes the call backs from authorization server.
 * At the initialization, it registers this web app as an oauth app, if it is not already registered.
 */
public class OAuth2ClientServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            // Load configuration parameters.
            WebAppConfig webAppConfig = WebAppConfig.getInstance();
            webAppConfig.setAppName(config.getInitParameter("appName"));
            webAppConfig.setConsumerKey(config.getInitParameter("consumerKey"));
            webAppConfig.setConsumerSecret(config.getInitParameter("consumerSecret"));
            webAppConfig.setAuthzServerURL(config.getInitParameter("authorizationServerUrl"));
            webAppConfig.setCallbackURL(config.getInitParameter("callBackUrl"));
            webAppConfig.setTrustStorePath(config.getInitParameter("trustStorePath"));
            webAppConfig.setTrustStorePassword(config.getInitParameter("trustStorePassword"));
            //TODO: register the oauth app if not already registered.
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        if("OpenID-Connect".equals(req.getParameter("authType"))){
            //get the open-id request from OAuthRESTClient and send to Authz Server
            String url = new OAuthRESTClient().getOpenIDConnectAuthRequest();
            resp.sendRedirect(url);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
