package com.anhvurz90.io;

import java.io.File;
import java.io.IOException;

public class CreateFileExample {
	
	public static void main(String... args) {
		File file = new File("file1.txt");
		try {
	    if (file.createNewFile()) {
	    	System.out.println("File created successfully!");
	    } else {
	    	System.out.println("File already exists!");
	    }
    } catch (IOException e) {
	    e.printStackTrace();
    }
	}
}
