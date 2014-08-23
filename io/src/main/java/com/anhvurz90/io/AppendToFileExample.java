package com.anhvurz90.io;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AppendToFileExample {

  public static void main(String... args) {
    try {
      String data = " This content will append to tne end of the file\n";
      File file = new File("javaio-appendfile.txt");
      
      if (!file.exists()) {
        file.createNewFile();
      }
      
      FileWriter fileWriter = new FileWriter(file.getName(), true);
      BufferedWriter bw = new BufferedWriter(fileWriter);
      bw.write(data);
      bw.close();
      
      System.out.println("Done!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
