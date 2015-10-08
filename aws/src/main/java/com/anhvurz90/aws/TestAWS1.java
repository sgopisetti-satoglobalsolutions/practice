package com.anhvurz90.aws;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */


public class TestAWS1 {

    public static void main(String[] args) {

        // create a new SNS client and set endpoint
        AmazonSNSClient snsClient = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());
        snsClient.setRegion(Region.getRegion(Regions.US_WEST_2));

        // publish to an SNS topic
        String topicArn = "arn:aws:sns:us-west-2:401612810481:HelloWorld";
        String msg = "My text published to SNS topic from java app by iam anhvurz90 but root";
        PublishRequest publishRequest = new PublishRequest(topicArn, msg);
        PublishResult publishResult = snsClient.publish(publishRequest);
        // print MessageId of message published to SNS topic
        System.out.println("MessageId - " + publishResult.getMessageId());
    }
}
