package com.anhvurz90.xml.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {
  
  public static void main(String... args) {
    //marshalling
    Customer customer = new Customer();
    customer.setId(100);
    customer.setName("mkyong");
    customer.setAge(29);
    
    try {
      File file = new File("file.xml");
      JAXBContext jaxbContext
         = JAXBContext.newInstance(Customer.class);
      Marshaller jaxbMarshaller 
         = jaxbContext.createMarshaller();
      //output pretty printed
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      
      jaxbMarshaller.marshal(customer, file);
      jaxbMarshaller.marshal(customer, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    
    
    //unmarshalling
    try {
      File file = new File("file.xml");
      JAXBContext jaxbContext 
        = JAXBContext.newInstance(Customer.class);
      Unmarshaller jaxbUnmarshaller
        = jaxbContext.createUnmarshaller();
      
      Customer cust1
        = (Customer)jaxbUnmarshaller.unmarshal(file);
      
      System.out.println(customer);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

}
