package com.anhvurz90.practice.spring.core.sample1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String... args) throws BeansException {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("Spring-Module.xml");
		HelloWorld helloBean = context.getBean("helloBean", HelloWorld.class);
		helloBean.printHello();
	}
}
