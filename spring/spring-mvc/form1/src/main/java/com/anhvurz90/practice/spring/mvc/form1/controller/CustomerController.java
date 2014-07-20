package com.anhvurz90.practice.spring.mvc.form1.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.anhvurz90.practice.spring.mvc.form1.entity.Customer;

public class CustomerController extends SimpleFormController {
  
  public CustomerController() {
    setCommandClass(Customer.class);
    setCommandName("customerForm");
  }
  
  @Override
  protected ModelAndView onSubmit(
      HttpServletRequest request,
      HttpServletResponse response,
      Object command, BindException error)throws Exception {
    Customer customer = (Customer)command;
    System.out.println(customer);
    return new ModelAndView("CustomerSuccess", "customer", customer);
  }
  
  @Override
  protected Object formBackingObject(HttpServletRequest request) 
    throws Exception {
    Customer cust = new Customer();
    //Make "Spring MVC" as default checked value
    cust.setFavFrameworks(new String[] {"Spring MVC"});
    //Make "Male" as default radio button selected value
    cust.setSex("M");
    //Make "Hibernate" as the default java skills selection
    cust.setJavaSkills("Hibernate");
    //initialize a hidden value
    cust.setSecretValue("I'm hidden value");
    return cust;
  }
  
  @Override
  protected Map referenceData(HttpServletRequest request) throws Exception {
    Map referenceData = new HashMap();
    
    //Data referencing for web framework checkboxes
    List<String> webFrameworkList = 
        Arrays.asList(new String[]{"Spring MVC", "Strut 1", "Strut 2", "JSF", "Apache WIcket"});
    referenceData.put("webFrameworkList", webFrameworkList);
    
    //Data referencing for number radio buttons
    List<String> numberList =
        Arrays.asList(new String[]{"Number 1", "Number 2",
                                   "Number 3", "Number 4",
                                   "Number 5"});
    referenceData.put("numberList", numberList);
    
    //Data referencing for country dropdown box
    Map<String, String> country = new LinkedHashMap<String, String>();
    country.put("US", "United State");
    country.put("CHINA", "China");
    country.put("SG", "Singapore");
    country.put("MY", "Malaysia");
    referenceData.put("countryList", country);
    
    //Data referencing for java skills list box
    Map<String, String> javaSkill = new LinkedHashMap<String, String>();
    javaSkill.put("Hibernate", "Hibernate");
    javaSkill.put("Spring", "Spring");
    javaSkill.put("Apache Wicket", "Apache Wicket");
    javaSkill.put("Struts", "Struts");
    referenceData.put("javaSkillList", javaSkill);
    
    return referenceData;
  }
  
}
