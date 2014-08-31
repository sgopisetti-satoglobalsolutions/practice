package com.anhvurz90.json.jackson;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by Owner on 6/26/14.
 */
public class JsonPrettyPrint {

    public static void main(String[] args) throws Exception {
        User user = new User();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(user));
        System.out.println("---------------------------------");
        System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(user));
        System.out.println("---------------------------------");
        String test = "{\"age\":29,\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"],\"name\":\"mkyong\"}";
        System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(test));
        System.out.println("---------------------------------");
        Object object = mapper.readValue(test, Object.class);
        System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(object));
    }
}
