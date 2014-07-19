package com.anhvurz90.practice.spring.core.sample1;

public class HelloWorld {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printHello() {
		System.out.format("Hello ! %s\n", name);
	}
}
