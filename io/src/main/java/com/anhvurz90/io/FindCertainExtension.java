package com.anhvurz90.io;

import java.io.File;
import java.io.FilenameFilter;

public class FindCertainExtension {

  private static final String FILE_DIR = "D:\\Job";
  private static final String FILE_IMG_EXT = ".bmp";
  
  public static void main(String[] args) {
    new FindCertainExtension().listFile(FILE_DIR, FILE_IMG_EXT);
  }
  
  public void listFile(String folder, String ext) {
    GenericExtFilter filter = new GenericExtFilter(ext);
    File dir = new File(folder);
    if (!dir.isDirectory()) {
      System.out.format("Directory does not exist: %s\n", FILE_DIR);
      return;
    }
    
    // list out all the file name and filter by the extension
    String[] list = dir.list(filter);
    
    if (list.length == 0) {
      System.out.format("No file end with: %s\n", ext);
      return;
    }
    
    for (String file : list) {
      String temp = new StringBuffer(FILE_DIR).append(File.separator).append(file).toString();
      System.out.format("File: %s\n", temp);
    }
  }
  
  public class GenericExtFilter implements FilenameFilter {
    private String ext;
    
    public GenericExtFilter(String ext) {
      this.ext = ext;
    }
    
    public boolean accept(File dir, String name) {
      return (name.endsWith(ext));
    }
  }
}
