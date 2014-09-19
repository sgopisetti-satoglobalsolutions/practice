package com.anhvurz90.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Create this XML File:
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
 * <company>
 *  <staff id = "1">
 *    <firstname>yong</firstname>
 *    <lastname>mook kim</lastname>
 *    <nickname>mkyong</nickname>
 *    <salary>100000</salary>
 *  </staff>
 * </company>
 * @author Anh Vu
 *
 */
public class WriteXMLFile {

  public static void main(String[] args) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      
      // root element
      Document doc = docBuilder.newDocument();
      Element rootElem = doc.createElement("company");
      doc.appendChild(rootElem);
      
      // staff element
      Element staff = doc.createElement("staff");
      rootElem.appendChild(staff);
      
      // set attribute to staff element
      Attr attr = doc.createAttribute("id");
      attr.setValue("1");
      staff.setAttributeNode(attr);// shorten way: staff.setAttribute("id", "1");
      
      // firstname element
      Element firstname = doc.createElement("firstname");
      firstname.appendChild(doc.createTextNode("yong"));
      staff.appendChild(firstname);

      // lastname element
      Element lastname = doc.createElement("lastname");
      lastname.appendChild(doc.createTextNode("mook kim"));
      staff.appendChild(lastname);
      
      // nickname element
      Element nickname = doc.createElement("nickname");
      nickname.setTextContent("mkyong");
      staff.appendChild(nickname);
      
      // salary element
      Element salary = doc.createElement("salary");
      salary.setTextContent("100000");
      staff.appendChild(salary);
      
      //------------------------------------------------------------------------
      //  write the content into xml file
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult ret = new StreamResult("file3.xml");
      
      // Output to console for testing
      // StreamResult ret = new StreamResult(System.out);
      transformer.transform(source,  ret);
      System.out.println("File saved!");
    } catch (ParserConfigurationException | TransformerException e) {
      e.printStackTrace();
    }
  }
}
