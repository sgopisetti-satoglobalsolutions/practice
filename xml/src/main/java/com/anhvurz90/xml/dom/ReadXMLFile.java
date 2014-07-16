package com.anhvurz90.xml.dom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ReadXMLFile {

	public static void main(String... args) {
		try {
			File fXmlFile = new File("staff.xml");
			DocumentBuilderFactory dbFactory
				= DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    
	    doc.getDocumentElement().normalize();
	    System.out.format("Root element: %s\n", 
	    		doc.getDocumentElement().getNodeName());
	    
	    NodeList nList = doc.getElementsByTagName("staff");//all elements, in all levels
	    
	    System.out.println("----------------------------");
	    
	    for (int i = 0; i < nList.getLength(); i++) {
	    	Node node = nList.item(i);
	    	System.out.format("Current element: %s\n", node.getNodeName());
	    	if (node.getNodeType() == Node.ELEMENT_NODE){
	    		Element element = (Element)node;
	    		System.out.format("Staff id: %s\n", element.getAttribute("id"));
	    		System.out.format("First name: %s\n", element.getElementsByTagName("firstname").item(0).getTextContent());
	    		System.out.format("Last name: %s\n", element.getElementsByTagName("lastname").item(0).getTextContent());
	    		System.out.format("Nick name: %s\n", element.getElementsByTagName("nickname").item(0).getTextContent());
	    		System.out.format("Salary: %s\n", element.getElementsByTagName("salary").item(0).getTextContent());
	    	}
	    }
	    
    } catch (IOException | SAXException | ParserConfigurationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
		
	}
}
