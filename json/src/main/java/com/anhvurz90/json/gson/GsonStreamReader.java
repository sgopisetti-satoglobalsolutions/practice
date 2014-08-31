package com.anhvurz90.json.gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.stream.JsonReader;

public class GsonStreamReader {
  public static void main(String... args) {
    try {
      JsonReader reader = new JsonReader(new FileReader("user.json"));
      reader.beginObject();
      while (reader.hasNext()) {
        String name = reader.nextName();
        if ("name".equals(name)) {
          System.out.println(reader.nextString());
        } else if ("age".equals(name)) {
          System.out.println(reader.nextInt());
        } else if ("messages".equals(name)) {
          reader.beginArray();
          while (reader.hasNext()) {
            System.out.println(reader.nextString());
          }
          reader.endArray();
        } else {
          reader.skipValue();
        }
      }
      
      reader.endObject();
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
