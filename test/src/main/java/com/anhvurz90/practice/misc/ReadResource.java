package com.anhvurz90.practice.misc;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;

public class ReadResource {
  public static void main(String[] args) {
    ReadResource r = new ReadResource();
    System.out.println(r.getFile("test.txt"));
    System.out.println(r.getFileWithUtil("test.txt"));
  }
  
  private String getFile(String filePath) {
    StringBuilder ret = new StringBuilder();
    
    //Get file from resource folder
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(filePath).getFile());
    
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        ret.append(line).append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return ret.toString();
  }
  
  private String getFileWithUtil(String filePath) {
    System.out.println("Get file with IOUtils:");
    String result = "";
    
    ClassLoader classLoader = getClass().getClassLoader();
    try {
      result = IOUtils.toString(classLoader.getResourceAsStream(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return result;
  }
}
