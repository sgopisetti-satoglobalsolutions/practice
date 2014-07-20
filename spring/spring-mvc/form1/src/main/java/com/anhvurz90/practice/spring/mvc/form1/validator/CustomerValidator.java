package com.anhvurz90.practice.spring.mvc.form1.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.anhvurz90.practice.spring.mvc.form1.entity.Customer;

public class CustomerValidator implements Validator {

  @Override
  public boolean supports(Class clazz) {
    return Customer.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
        "required.userName", "Field name is required!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
        "required.address", "Field address is required!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password",
        "required.password", "Field password is required");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", 
        "required.confirmPassword", "Field confirmPassword is required!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex",
        "required.sex", "Field sex is required!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber",
        "required.favNumber", "Field favNumber is required!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "javaSkills",
        "required.javaSkills", "Field javaSkills is required!");
    
    Customer cust = (Customer)target;
    
    if (!(cust.getPassword().equals(cust.getConfirmPassword()))) {
      errors.rejectValue("password", "notmatch.password");
    }
    
    if (cust.getFavFrameworks().length == 0) {
      errors.rejectValue("favFramework",  "required.favFramework");
    }
    
    if ("NONE".equals(cust.getCountry())) {
      errors.rejectValue("country", "required.country");
    }
  }
}
