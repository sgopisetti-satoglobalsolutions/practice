package com.anhvurz90.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {

  private Pattern pattern;
  private Matcher matcher;
  
  private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
  /**
   * Description:
   * ^                  # Start of the line
   *   [a-z0-9_-]       # Match characters and symbols in the list, a-z, 0-9, underscore, hyphen
   *             {3,15} # Length at least 3 characters and maximum length of 15
   * $                  # End of the line 
   */
  
  public UsernameValidator() {
    pattern = Pattern.compile(USERNAME_PATTERN);
  }
  
  /**
   * Validate username with regular expression
   * @param username username for validation
   * @return true valid usename, false invalid username 
   */
  public boolean validate(final String username) {
    matcher = pattern.matcher(username);
    return matcher.matches();
  }
  
  public static void main(String[] args) {
    UsernameValidator validator = new UsernameValidator();
    String s = "mkyong34";
    System.out.format("%s %s\n", s, validator.validate(s)? "matches" : "not matches");
    
    s = "mkyong_2002";
    System.out.format("%s %s\n", s, validator.validate(s)? "matches" : "not matches");

    s = "mkyong-2002";
    System.out.format("%s %s\n", s, validator.validate(s)? "matches" : "not matches");
    
    s = "mk3-4_yong";
    System.out.format("%s %s\n", s, validator.validate(s)? "matches" : "not matches");
    
    s = "mk";
    System.out.format("%s %s\n", s, validator.validate(s)? "matches" : "not matches");
    
    s = "mk@yong";
    System.out.format("%s %s\n", s, validator.validate(s)? "matches" : "not matches");
    
    s = "mkyong123456789_-";
    System.out.format("%s %s\n", s, validator.validate(s)? "matches" : "not matches");
  }
}
