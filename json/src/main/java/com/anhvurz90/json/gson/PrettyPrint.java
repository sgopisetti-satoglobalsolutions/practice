package com.anhvurz90.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrettyPrint {
  
  public static void main(String... args) {
    DataObject obj = new DataObject();
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(obj);
    System.out.println(json);
  }
}
