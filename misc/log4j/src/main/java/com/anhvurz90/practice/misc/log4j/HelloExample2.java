/*
 * Copyright (C) 2003-2015 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.anhvurz90.practice.misc.log4j;

import org.apache.log4j.Logger;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Apr 19, 2015  
 */
public class HelloExample2 {

  final static Logger logger = Logger.getLogger(HelloExample2.class);
  
  public static void main(String[] args) {
    HelloExample2 obj = new HelloExample2();
    try {
      obj.divide();
    } catch (ArithmeticException ex) {
      logger.error("Sorry, something wrong!", ex);
    }
  }
  
  private void divide() {
    int i = 10 / 0;
  }
}
