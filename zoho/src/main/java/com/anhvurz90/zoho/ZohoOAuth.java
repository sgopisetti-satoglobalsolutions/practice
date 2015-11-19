/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.zoho;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class ZohoOAuth {
    public static void main(String a[]) {
        try {
            String targetURL =
                    "https://accounts.zoho.com/apiauthtoken/nb/create?SCOPE=ZohoCRM/crmapi&EMAIL_ID=anhvurz90@gmail.com&PASSWORD=temppassword&DISPLAY_NAME=app1";
            GetMethod get = new GetMethod(targetURL);
            // get.setParameter("authtoken", authtoken);
            // get.setParameter("scope", "crmapi");
            HttpClient httpclient = new HttpClient();
            httpclient.executeMethod(get);
            String postResp = get.getResponseBodyAsString();
            System.out.println("The Response from the server : " + postResp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}