package com.anhvurz90.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageValidator {

  private Pattern pattern;
  private Matcher matcher;
  
  private static final String IMAGE_PATTERN 
                  = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
  /**
   * Description:
   * (              #Start of the group #1
   *   [^\s]+       #  must contain one or more anything (except for white space)
   *   (            #  start of the group #2
   *     \.         #    follow by a dot "."
   *     (?i)       #    ignore the case sensitive checking for the following characters
   *     (          #      start of the group #3
   *       jpg      #        contains characters "jpg"
   *       |        #        ..or
   *       png      #        contains characters "png"
   *       |        #        ..or
   *       gif      #        contains characters "gif"
   *       |        #        ..or
   *       bmp      #        contains characters "bmp"
   *     )          #      end of the group #3
   *   )            #  end of the group #2
   * )              #End of the group #1
   */
  
  public ImageValidator() {
    pattern = Pattern.compile(IMAGE_PATTERN);
  }
  
  /**
   * Validate image with regular expression
   * @param image image for validation
   * @return  true valid image, false invalid image
   */
  public boolean validate(final String image) {
    matcher = pattern.matcher(image);
    boolean ret = matcher.matches();
    System.out.format("%s : %s\n", image, ret ? "OK" : "NOK");
    return ret;
  }
  
  public static void main(String[] args) {
    ImageValidator iValidator = new ImageValidator();
    iValidator.validate("a.jpg");
    iValidator.validate("a.gif");
    iValidator.validate("a.png");
    iValidator.validate("a.bmp");
    iValidator.validate("..jpg");
    iValidator.validate("..gif");
    iValidator.validate("..png");
    iValidator.validate("..bmp");
    iValidator.validate("a.JPG");
    
    iValidator.validate(".jpg");
    iValidator.validate(".gif");
    iValidator.validate(".gpg");
    iValidator.validate(" .gif");
    iValidator.validate("a.txt");
    iValidator.validate("bmp");
    iValidator.validate("a.mp3");
  }
}
