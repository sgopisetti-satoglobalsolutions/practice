package com.anhvurz90.io;

import java.io.File;
import java.io.IOException;

public class FilePathExample {

	public static void main(String... args) {
		String file = "file2.txt";
		String filePath = "";
		String workingDir = System.getProperty("user.dir");
		
		filePath = workingDir + File.separator + file;
		System.out.format("FilePath value: %s\n", filePath);
		File f = new File(filePath);
		try {
	    if (f.createNewFile()) {
	    	System.out.println("File created!");
	    } else {
	    	System.out.println("File already exists!");
	    }
    } catch (IOException e) {
	    e.printStackTrace();
    }
	}
}
