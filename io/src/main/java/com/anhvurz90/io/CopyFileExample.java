package com.anhvurz90.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileExample {

  public static void main(String[] args) {
    InputStream inS = null;
    OutputStream outS = null;
    
    try {
      File afile = new File("file1.txt");
      File bfile = new File("Bfile.txt");
      
      inS = new FileInputStream(afile);
      outS = new FileOutputStream(bfile);
      
      byte[] buf = new byte[1024];
      
      int length;
      //copy the file content in bytes
      while ((length = inS.read(buf)) > 0) {
        outS.write(buf, 0, length);
      }
      
      inS.close();
      outS.close();
      System.out.println("File is copied successfully!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
