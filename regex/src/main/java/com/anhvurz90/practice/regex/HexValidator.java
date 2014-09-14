package com.anhvurz90.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexValidator {
  
  private Pattern pattern;
  private Matcher matcher;
  
  private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
  /**
   * Description:
   *  ^                       # start of the line
   *    #                     #   must contains a # symbol
   *      (                   #     start of group #1
   *        [A-Fa-f0-9]{6}    #       any string in the list, with length of 6
   *        |                 #         or
   *        [A-Fa-f0-9]{3}    #       any string in the list, with length of 3
 *        )                   #   end of group #1
   *  $                       # end of the line
   */
  
  public HexValidator() {
    pattern = Pattern.compile(HEX_PATTERN);
  }
  
  public boolean validate(final String hex) {
    System.out.format("String to validate: %s\n", hex);
    matcher = pattern.matcher(hex);
    boolean ret = matcher.matches();
    System.out.println(ret);
    return ret;
  }
  
  public static void main(String[] args) {
    HexValidator hv = new HexValidator();
    hv.validate("#1f1f1F");
    hv.validate("#AFAFAF");
    hv.validate("#1AFFa1");
    hv.validate("#222fff");
    hv.validate("#F00");
    
    hv.validate("123456");
    hv.validate("#afafah");
    hv.validate("#123abce");
    hv.validate("aFaE3f");
    hv.validate("F00");
    hv.validate("#afaf");
    hv.validate("#F0h");
  }
}
