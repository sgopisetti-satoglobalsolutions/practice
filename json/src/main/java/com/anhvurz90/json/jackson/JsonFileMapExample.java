package com.anhvurz90.json.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Owner on 6/25/14.
 */
public class JsonFileMapExample {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // read JSON from a file
            Map<String, Object> map = mapper.readValue(
                    new File("user.json"),
                    new TypeReference<HashMap<String,Object>>() {});

            System.out.println(map.get("name"));
            System.out.println(map.get("age"));
            System.out.println(map.get("messages"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
