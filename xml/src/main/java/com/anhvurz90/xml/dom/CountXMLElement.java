package com.anhvurz90.xml.dom;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CountXMLElement {

  public static void main(String[] args) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse("fileCount.xml");
      
      //NodeList list = doc.getElementsByTagName("staff");
      NodeList list = doc.getElementsByTagName("*");
      
      System.out.format("Total of elements: %d", list.getLength());
    } catch (ParserConfigurationException | IOException | SAXException e) {
      e.printStackTrace();
    }
  }
}
