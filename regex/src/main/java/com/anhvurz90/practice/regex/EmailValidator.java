package com.anhvurz90.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
  
  private Pattern pattern;
  private Matcher matcher;
  
  /**
   * Description:
   * ^                      # start of the line
   *  [_A-Za-z0-9-\\+]+     #   must start with string in the bracket [], must contain one or more (+)
   *  (                     #   start of group #1
   *    \\.[A-Za-z0-9-]+    #    follow by a dot "." and string in the bracket [], must contain one or more (+)
   *  )*                    #   end of group #1, this group is optional (*)
   *  
   *  @                     #   must contain a "@" symbol
   *  
   *  [A-Za-z0-9-]+         #   follow by string in the bracket [], must contains one or more (+)
   *  (                     #   start of group #2 - first level TLD checking
   *    \\.[A-Za-z0-9]+     #     follow by a dot "." and string in the bracket [], must contain one or more (+)
   *  )*                    #   end of group #2, this group is optional (*)
   *  (                     #   start of group #3 - second level TLD checking
   *    \\.[A-Za-z0-9]{2,1} #  follow by a dot "." and string in the bracket [], with minimum length of 2
   *  )                     #  end of group #3
   * $                      # end of the line
   */
  private static final String EMAIL_PATTERN = 
      "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + 
      "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  
  public EmailValidator() {
    pattern = Pattern.compile(EMAIL_PATTERN);
  }
  
  public boolean validate(final String email) {
    System.out.format("Email to validate: %s\n", email);
    matcher = pattern.matcher(email);
    boolean ret = matcher.matches();
    System.out.format("Result: %b\n", ret);
    return ret;
  }
  
  public static void main(String[] args) {
    EmailValidator eValidator = new EmailValidator();

    // Valid Emails
    eValidator.validate("mkyong@yahoo.com");
    eValidator.validate("mkyong-100@yahoo.com");
    eValidator.validate("mkyong.100@yahoo.com");
    eValidator.validate("mkyong111@mkyong.com");
    eValidator.validate("mkyong-100@mkyong.net");
    eValidator.validate("mkyong.100@mkyong.com.au");
    eValidator.validate("mkyong@1.com");
    eValidator.validate("mkyong@gmail.com.com");
    eValidator.validate("mkyong+100@gmail.com");
    eValidator.validate("mkyong-100@yahoo-test.com");
    
    // Invalid Emails
    eValidator.validate("mkyong");// – must contains “@” symbol
    eValidator.validate("mkyong@.com.my");// – tld can not start with dot “.”
    eValidator.validate("mkyong123@gmail.a");// – “.a” is not a valid tld, last tld must contains at least two characters
    eValidator.validate("mkyong123@.com");// – tld can not start with dot “.”
    eValidator.validate("mkyong123@.com.com");// – tld can not start with dot “.”
    eValidator.validate(".mkyong@mkyong.com");// – email’s first character can not start with dot “.”
    eValidator.validate("mkyong()*@gmail.com");// – email’s is only allow character, digit, underscore and dash
    eValidator.validate("mkyong@%*.com");// – email’s tld is only allow character and digit
    eValidator.validate("mkyong..2002@gmail.com");// – double dots “.” are not allow
    eValidator.validate("mkyong.@gmail.com");// – email’s last character can not end with dot “.”
    eValidator.validate("mkyong@mkyong@gmail.com");// – double “@” is not allow
    eValidator.validate("mkyong@gmail.com.1a");// -email’s tld which has two characters can not contains digit
  }
}

