package com.anhvurz90.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample {

  public static void main(String...args) {
    String content = "This is a content to write into file";
    File file = new File("file3.txt");
    try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
      if (!file.exists()) {
        file.createNewFile();
      }
      
      br.write(content);
      
      System.out.println("Done!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
