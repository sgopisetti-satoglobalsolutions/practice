package com.anhvurz90.json.simple;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleWrite {

  public static void main(String... args) {
    JSONObject obj = new JSONObject();
    obj.put("name", "mkyong.com");
    obj.put("age",  new Integer(100));
    
    JSONArray list = new JSONArray();
    list.add("msg 1");
    list.add("msg 2");
    list.add("msg 3");
    
    obj.put("messages", list);
    
    try {
      FileWriter file = new FileWriter("test.json");
      file.write(obj.toJSONString());
      file.flush();
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    System.out.println(obj.toJSONString());
    System.out.println(obj);
  }
}
