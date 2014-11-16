package com.anhvurz90.xml.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ReadXMLFile {

  public static void main(String[] args) {
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File("staff.xml");
    try {
      Document document = builder.build(xmlFile);
      Element rootNode = document.getRootElement();
      List list = rootNode.getChildren("staff");
      for (int i = 0; i < list.size(); i++) {
        Element node = (Element)list.get(i);
        System.out.format("First Name: %s\n", node.getChildText("firstname"));
        System.out.format("Last Name: %s\n", node.getChildText("lastname"));
        System.out.format("Nick Name: %s\n", node.getChildText("nickname"));
        System.out.format("Salary: %s\n", node.getChildText("salary"));
      }
    } catch (IOException | JDOMException e) {
      e.printStackTrace();
    }
  }
}
