package com.anhvurz90.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

  private Pattern pattern;
  private Matcher matcher;
  
  private static final String PASSWORD_PATTERN = 
      "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=.*[`]).{6,20})";
  /**
   * Description:
   *  (                     # Start of group
   *    (?=.*\d)            #   must contains one digit from 0-9
   *    (?=.*[a-z]          #   must contains one lower case character
   *    (?=.*[A-Z]          #   must contains one upper case character
   *    (?=.*[@#$%])        #   must contains one special symbols in the list "@#$%"
   *                .       #     match anything with previous condition checking
   *                 (6-20) #       length at least 6 characters and maximum of 20
 *  )                       # End of group
   */
  
  public PasswordValidator() {
    pattern = Pattern.compile(PASSWORD_PATTERN);
  }
  
  /**
   * Validate password with regular expression
   * @param password password for validation
   * @return true valid password, false invalid password
   */
  public boolean validate(final String password) {
    System.out.format("Password to validate: %s\n", password);
    matcher = pattern.matcher(password);
    boolean ret = matcher.matches();
    System.out.println(ret);
    return ret;
  }
  
  public static void main(String[] args) {
    PasswordValidator pv = new PasswordValidator();
    pv.validate("mkyong1A@");
    pv.validate("m`kYOn12$");
    pv.validate("mY1A@");
    pv.validate("mkyong12@");
    pv.validate("mkyoNg12*");
    pv.validate("mkyonG$$");
    pv.validate("MKYONG12$");
  }
}
