package com.anhvurz90.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Owner on 6/25/14.
 */
public class JsonMapExample {
    public static void main(String[] args) {
        String json = "{\"name\":\"anhvu\", \"age\":\"29\"}";
        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper oMapper = new ObjectMapper();
        try {
            //convert JSON string to Map
            map = oMapper.readValue(json,
                    new TypeReference<HashMap<String, String>>(){});
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
