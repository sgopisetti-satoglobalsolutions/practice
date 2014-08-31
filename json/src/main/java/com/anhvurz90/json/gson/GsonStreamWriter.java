package com.anhvurz90.json.gson;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.stream.JsonWriter;

public class GsonStreamWriter {
  
  public static void main(String... args) {
    JsonWriter writer;
    try {
      writer = new JsonWriter(new FileWriter("user.json"));
      writer.beginObject();
      writer.name("name").value("mkyong");
      writer.name("age").value(29);
      
      writer.name("messages");
      writer.beginArray();
      writer.value("msg 1");
      writer.value("msg 2");
      writer.value("msg 3");
      writer.endArray();
      
      writer.endObject();
      writer.close();
      
      System.out.println("Done!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
