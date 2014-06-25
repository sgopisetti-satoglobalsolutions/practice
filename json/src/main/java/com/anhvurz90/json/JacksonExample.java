package com.anhvurz90.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: vuna
 * Date: 6/25/14
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class JacksonExample {
    public static void main(String[] args) throws Exception {
        User user = new User();
        ObjectMapper oMapper = new ObjectMapper();
        oMapper.writeValue(new File("user.json"), user);
        System.out.println("Write value:");
        System.out.println(oMapper.writeValueAsString(user));
        System.out.println(user);
        System.out.println("Read value:");
        User user2 = null;
        user2 = oMapper.readValue(new File("user.json"), User.class);
        System.out.println(user2);
    }
}
