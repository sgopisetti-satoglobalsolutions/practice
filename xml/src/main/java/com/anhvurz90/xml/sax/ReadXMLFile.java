package com.anhvurz90.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

  public static void main(String[] args) {
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      
      DefaultHandler handler = new EventHandler();
      
      saxParser.parse("fileCount.xml", handler);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  static class EventHandler extends DefaultHandler {
    private boolean bfname = false;
    private boolean blname = false;
    private boolean bnname = false;
    private boolean bsalary = false;
    
    public void startElement(String uri, String localName, String qName, Attributes atts) 
        throws SAXException {
      System.out.format("Start Element: %s\n", qName);
      switch (qName) {
        case "firstname": bfname = true; break;
        case "lastname":  blname = true; break;
        case "nickname":  bnname = true; break;
        case "salary":    bsalary = true; break;
      }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
      System.out.format("End Element: %s\n", qName);
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
      if (bfname) {
        System.out.format("First Name: %s\n", new String(ch, start, length));
        bfname = false;
      }
      
      if (blname) {
        System.out.format("Last Name: %s\n", new String(ch, start, length));
        blname = false;
      }
      
      if (bnname) {
        System.out.format("Nick Name: %s\n", new String(ch, start, length));
        bnname = false;
      }
      
      if (bsalary) {
        System.out.format("Salary: %s\n", new String(ch, start, length));
        bsalary = false;
      }
    }
  }
}
