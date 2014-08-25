package com.anhvurz90.json;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;

public class JacksonStreamExampleParser {

  public static void main(String... args) {
    
    try {
      JsonFactory jFactory = new JsonFactory();
      //read from file
      JsonParser jParser = jFactory.createJsonParser(new File("use.json"));
      //loop until token equals to "}"
      while (jParser.nextToken() != JsonToken.END_OBJECT) {
        String fieldName = jParser.getCurrentName();
        if ("name".equals(fieldName)) {
          //current token is "name",
          //move to next, which is "name"'s value
          jParser.nextToken();
          System.out.println(jParser.getText());//display "mkyong"
        }
        if ("age".equals(fieldName)) {
          //current token is "age",
          //move to next, which is "age"'s value
          jParser.nextToken();
          System.out.println(jParser.getIntValue());//display 29
        }
        if ("message".equals(fieldName)) {
          jParser.nextToken();
          //current token is "[", move next
          //messages is array, loop until token equal to "]"
          while (jParser.nextToken() != JsonToken.END_ARRAY) {
            //display msg1, msg2, msg3
            System.out.println(jParser.getText());
          }
        }
      }
      jParser.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
