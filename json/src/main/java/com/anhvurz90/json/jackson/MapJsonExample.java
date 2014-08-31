package com.anhvurz90.json.jackson;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Owner on 6/25/14.
 */
public class MapJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = "";

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", "anhvu");
            map.put("age", 29);

            //convert map to JSON string
            json = mapper.writeValueAsString(map);

            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
