package com.anhvurz90.io;

import java.io.File;

public class DeleteFileExample {

  public static void main(String[] args) {
    try {
      File file = new File("fileToDelete.txt");
      //create
      if (file.createNewFile()) {
        System.out.format("File %s created\n", file.getAbsolutePath());
      } else {
        System.out.println("File creation failed");
      }
      //delete
      if (file.delete()) {
        System.out.format("File %s deleted successfully", file.getCanonicalPath());
      } else {
        System.out.println("Delete operation is failed!");
      }
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
