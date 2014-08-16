package com.anhvurz90.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class BufferedReaderExample {

  public static void main(String... args) {
    try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        System.out.format("new line: '%s'\n", currentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
