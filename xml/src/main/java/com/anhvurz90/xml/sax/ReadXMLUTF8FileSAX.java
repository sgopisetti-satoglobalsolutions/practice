package com.anhvurz90.xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLUTF8FileSAX {

  public static void main(String[] args) {
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      DefaultHandler handler = new ReadXMLFile.EventHandler();
      
      File file = new File("file-utf.xml");
      InputStream inputStream = new FileInputStream(file);
      Reader reader = new InputStreamReader(inputStream, "UTF-8");
      
      InputSource is = new InputSource(reader);
      is.setEncoding("UTF-8");
      
      saxParser.parse(is, handler);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
