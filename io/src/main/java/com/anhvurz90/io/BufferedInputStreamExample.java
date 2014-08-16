package com.anhvurz90.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamExample {

  public static void main(String... args) {
    
    File file = new File("file1.txt");
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
    
    try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
      
      while (dis.available() != 0) {
        System.out.format("new line: '%s' --\n", dis.readLine());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fis.close();
        bis.close();
        dis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
