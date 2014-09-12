package com.anhvurz90.xml.dom;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyXMLFile {

  public static void main(String[] args) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse("file2.xml");
      
      //get the root eleemnt
      Node company = doc.getFirstChild();
      // Get the staff element, it may not working if tag has spaces, or
      // whatever weird characters in front...it's better to use
      // getElementsByTagName() to get it directly
      // Node staff = company.getFirstChild();
      
      // Get the staff element by tag name directly
      Node staff = doc.getElementsByTagName("staff").item(0);
      
      // update staff attribute
      NamedNodeMap attr = staff.getAttributes();
      Node nodeAttr = attr.getNamedItem("id");
      nodeAttr.setNodeValue("21");//nodeAttr.setNodeValue("2");
      
      // append a new node to staff
      Element age = doc.createElement("age");
      age.appendChild(doc.createTextNode("28"));
      staff.appendChild(age);
      
      // loop the staff child node
      NodeList list = staff.getChildNodes();
      for (int i = 0; i < list.getLength(); i++) {
        Node node = list.item(i);
        
        // get the salary element, and update the value
        if ("salary".equals(node.getNodeName())) {
          node.setTextContent("200001");
        }
        
        // remove firstname
        if ("firstname".equals(node.getNodeName())) {
          staff.removeChild(node);
        }
      } // of for
      
      // write the content into xml file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File("file2_result.xml"));
      transformer.transform(source, result);
      
      System.out.println("Done!");
      
    } catch(ParserConfigurationException | TransformerException | IOException | SAXException e) {
      e.printStackTrace();
    }
  }
}
