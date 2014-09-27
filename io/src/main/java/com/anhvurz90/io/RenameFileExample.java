package com.anhvurz90.io;

import java.io.File;

public class RenameFileExample {

  public static void main(String[] args) {
    File oldFile = new File("oldfile.txt");
    File newFile = new File("newfile.txt");
    if (oldFile.renameTo(newFile)) {
      System.out.println("Rename successfully");
    } else {
      System.out.println("Rename failed!");
    }
  }
}
