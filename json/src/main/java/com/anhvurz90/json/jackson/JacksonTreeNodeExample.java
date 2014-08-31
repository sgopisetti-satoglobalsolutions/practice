package com.anhvurz90.json.jackson;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

/**
 * Created by Owner on 6/26/14.
 */
public class JacksonTreeNodeExample {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("user.json"));
            JsonNode rootNode = mapper.readTree(reader);
            JsonNode nameNode = rootNode.path("name");
            System.out.println(nameNode.getTextValue());

            JsonNode ageNode = rootNode.path("age");
            System.out.println(ageNode.getIntValue());

            JsonNode msgsNode = rootNode.path("messages");
            for (Iterator<JsonNode> iter = msgsNode.iterator();iter.hasNext();) {
                JsonNode msgNode = iter.next();
                System.out.println(msgNode.getTextValue());
            }

            ((ObjectNode)rootNode).put("name", "updated name");
            ((ObjectNode)rootNode).put("nickname", "nickName");
            ((ObjectNode) rootNode).remove("age");
            System.out.println(rootNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
