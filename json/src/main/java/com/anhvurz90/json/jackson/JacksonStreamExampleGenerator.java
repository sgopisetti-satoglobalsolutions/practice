package com.anhvurz90.json.jackson;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

public class JacksonStreamExampleGenerator {
  public static void main(String... args) {
    try {
      JsonFactory jFactory = new JsonFactory();
      //write to file
      JsonGenerator jGenerator = jFactory.createJsonGenerator(new File("use.json"),
                                                              JsonEncoding.UTF8);
      jGenerator.writeStartObject();//{
      
      jGenerator.writeStringField("name", "mkyong");
      jGenerator.writeNumberField("age", 29);
      
      jGenerator.writeFieldName("message");//messages
      jGenerator.writeStartArray();//[
      
      jGenerator.writeString("msg 1"); // msg1
      jGenerator.writeString("msg 2"); // msg2
      jGenerator.writeString("msg 3"); // msg3
      
      
      jGenerator.writeEndArray();//]
      jGenerator.writeEndObject();//}
      
      jGenerator.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
