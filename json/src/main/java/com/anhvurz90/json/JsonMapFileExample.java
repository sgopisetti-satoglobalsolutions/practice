package com.anhvurz90.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 6/25/14.
 */
public class JsonMapFileExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "anhvu");
        map.put("age", 29);

        List<Object> list = new ArrayList<Object>();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        map.put("messages", list);

        try {
            mapper.writeValue(new File("user.json"), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
