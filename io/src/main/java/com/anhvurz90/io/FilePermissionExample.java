package com.anhvurz90.io;

import java.io.File;
import java.io.IOException;

public class FilePermissionExample {

	public static void main(String... args) {
		try {
			File file = new File("file1.txt");
			if (file.exists()) {
				System.out.format("Is Executable: %s\n", file.canExecute());
				System.out.format("Is Writable: %s\n", file.canWrite());
				System.out.format("Is Readable: %s\n", file.canRead());
			}
			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);
			
			System.out.format("Is execute allow: %s\n", file.canExecute());
			System.out.format("Is read allow: %s\n", file.canRead());
			System.out.format("Is write allow: %s\n", file.canWrite());
			
			if (file.createNewFile()) {
				System.out.println("File created!");
			} else {
				System.out.println("File already exists!");
			}
			
			//Runtime.getRuntime().exec("dir");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
