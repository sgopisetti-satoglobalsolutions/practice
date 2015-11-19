/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.zoho;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class ZohoAPI {
    public static void main(String a[]) {
        try {
            String authtoken = "";
            String targetURL = "https://crm.zoho.com/crm/private/json/Potentials/getRecords";
            PostMethod post = new PostMethod(targetURL);
            post.setParameter("authtoken", authtoken);
            post.setParameter("scope", "crmapi");
            post.setParameter("selectColumns",
                    "Potentials(Amount,Stage,Potential Owner,Potential Name,Closing Date,Closing Date,Lead Source)");
            post.setParameter("fromIndex", "2");
            post.setParameter("toIndex", "3");
            HttpClient httpclient = new HttpClient();
            httpclient.executeMethod(post);
            String postResp = post.getResponseBodyAsString();
            // postResp = canonicalize(postResp);
            System.out.println("The Response from the server : " + postResp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}