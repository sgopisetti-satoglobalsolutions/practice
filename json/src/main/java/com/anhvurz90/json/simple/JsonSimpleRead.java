package com.anhvurz90.json.simple;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleRead {
  
  public static void main(String... args) {
    JSONParser parser = new JSONParser();
    
    try {
      Object obj = parser.parse(new FileReader("test.json"));
      JSONObject jsonObject = (JSONObject)obj;
      String name = (String)jsonObject.get("name");
      System.out.println(name);
      long age = (Long)jsonObject.get("age");
      System.out.println(age);
      
      JSONArray msg = (JSONArray)jsonObject.get("messages");
      for(Iterator<String> iter = msg.iterator(); iter.hasNext();) {
        System.out.println(iter.next());
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }
}
