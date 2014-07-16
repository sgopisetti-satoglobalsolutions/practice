package com.anhvurz90.xml.dom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlFile2 {

	public static void main(String... args) {
		try {
			File file = new File("staff.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			System.out.format("Root element: %s\n", doc.getDocumentElement().getNodeName());
			
			if (doc.hasChildNodes()) {
				printNodes(doc.getChildNodes(), " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printNodes(NodeList nodeList, String indent) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node node = nodeList.item(count);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				//get node name and value
				System.out.format("\n%sNode name = %s [OPEN]\n", indent, node.getNodeName());
				System.out.format("\n%sNode value = %s\n", indent, node.getTextContent());
				//get attribute names and values
				if (node.hasAttributes()) {
					NamedNodeMap nodeMap = node.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node n = nodeMap.item(i);
						System.out.format("%sattr name: %s\n", indent, n.getNodeName());
						System.out.format("%sattr value: %s\n", indent, n.getNodeValue());
					}
				}
				
				if (node.hasChildNodes()) {
					printNodes(node.getChildNodes(), indent + " ");
				}
				
				System.out.format("\n%sNode name = %s [CLOSE]\n", indent, node.getNodeName());
			}
		}
	}
	
}
