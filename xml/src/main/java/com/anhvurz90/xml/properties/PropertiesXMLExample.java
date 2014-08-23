package com.anhvurz90.xml.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
public class PropertiesXMLExample {
  public static void main(String... args) throws IOException {
    Properties props = new Properties();
    
    InputStream is = new FileInputStream("email-configuration.xml");
    props.loadFromXML(is);;
    
    String email = props.getProperty("email.support");
    
    System.out.println(email);
  }
}
