package com.anhvurz90.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileExample {

  public static void main(String... args) {
    File file = new File("file3.txt");
    String content = "This is a text content";
    
    try (FileOutputStream fos = new FileOutputStream(file)) {
      if (!file.exists()) {
        file.createNewFile();
      }
      
      byte[] contentInBytes = content.getBytes();
      
      fos.write(contentInBytes);
      fos.flush();
      fos.close();
      
      System.out.println("Done!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
