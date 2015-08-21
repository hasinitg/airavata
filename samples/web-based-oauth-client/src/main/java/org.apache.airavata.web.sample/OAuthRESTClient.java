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

import org.apache.airavata.security.AiravataSecurityException;
import org.apache.airavata.security.util.TrustStoreManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * This performs REST operations with authorization server.
 */
public class OAuthRESTClient {
    /**
     * build the request to obtain authorization grant under authorization code grant type and openid connect scope.
     *
     * @return
     */
    public String getOpenIDConnectAuthRequest() {
        return "https://localhost:9443/oauth2/authorize?response_type=code&scope=openid&client_id=buBjvhmiFmAwtROQvatz7V8DnUga" +
                "&redirect_uri=http://localhost:8080/web-based-oauth-client-app/openidconnect";
    }

    public SessionInfo retrieveAccessTokenNIDToken(String code) throws AiravataSecurityException {
        HttpPost postMethod = null;
        try {
            //initialize trust store to handle SSL handshake with WSO2 IS properly.
            TrustStoreManager trustStoreManager = new TrustStoreManager();
            SSLContext sslContext = trustStoreManager.initializeTrustStoreManager(WebAppConfig.getInstance().getTrustStorePath(),
                    WebAppConfig.getInstance().getTrustStorePassword());
            //create https scheme with the trust store
            org.apache.http.conn.ssl.SSLSocketFactory sf = new org.apache.http.conn.ssl.SSLSocketFactory(sslContext);
            //TODO: below the default IS SSL port is hard coded, extract it from the url in the config
            Scheme httpsScheme = new Scheme("https", sf, 9443);

            HttpClient httpClient = new DefaultHttpClient();
            //set the https scheme in the httpclient
            httpClient.getConnectionManager().getSchemeRegistry().register(httpsScheme);

            postMethod = new HttpPost(WebAppConfig.getInstance().getAuthzServerURL() + "/token");

            /*build the HTTP request with relevant params */
            String authInfo = WebAppConfig.getInstance().getConsumerKey() + ":" + WebAppConfig.getInstance().getConsumerSecret();
            String authHeader = new String(Base64.encodeBase64(authInfo.getBytes()));

            postMethod.setHeader("Content-Type", "application/x-www-form-urlencoded");
            postMethod.setHeader("Authorization", "Basic " + authHeader);

            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

            urlParameters.add(new BasicNameValuePair("client_id", WebAppConfig.getInstance().getConsumerKey()));
            urlParameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
            urlParameters.add(new BasicNameValuePair("code", code));
            urlParameters.add(new BasicNameValuePair("redirect_uri", WebAppConfig.getInstance().getCallbackURL()));

            postMethod.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpResponse response = httpClient.execute(postMethod);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            /*parse the JSON response and extract items and set in the session info,
            in order for them to be set in the HttpSession.*/
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(result.toString());

            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.setAccessToken(jsonObject.get("access_token"));
            sessionInfo.setExpiresIn(Long.valueOf(jsonObject.get("expires_in")));
            sessionInfo.setRefreshToken(jsonObject.get("refresh_token"));

            //parse ID Token and extract subject
            String idToken = jsonObject.get("id_token");
            String[] idTokenParts = idToken.split("\\.");
            if (idTokenParts.length == 1) {

                //only the ID Token header is set. Then we can not expect to obtain user name, which is an issue.
                //handle this properly by showing an appropriate error to the user in a real gateway implementation.

            } else if (idTokenParts.length >= 2) {

                //we are interested in the payload.
                String payload = idTokenParts[1];

                //base64 decode it.
                byte[] 
            }

        } catch (ClientProtocolException e) {
            throw new AiravataSecurityException(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            throw new AiravataSecurityException(e.getMessage(), e);
        } catch (IOException e) {
            throw new AiravataSecurityException(e.getMessage(), e);
        } /*catch (ParseException e) {
            throw new AiravataSecurityException(e.getMessage(), e);
        }*/ finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
        return new SessionInfo();
    }

}
