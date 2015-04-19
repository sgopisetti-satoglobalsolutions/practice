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
public class HelloExample {
  final static Logger logger = Logger.getLogger(HelloExample.class);
  
  public static void main(String[] args) {
    HelloExample obj = new HelloExample();
    obj.runMe("mkyong");
  }
  
  private void runMe(String param) {
    if (logger.isDebugEnabled()) {
      logger.debug("This is debug: " + param);
    }
    if (logger.isInfoEnabled()) {
      logger.info("This is info: " + param);
    }
    
    logger.warn("This is warn:" + param);
    logger.error("This is error: " + param);
    logger.fatal("This is fatal: " + param);
  }

}

//package org.apache.log4j;
//
//public class Priority {
// 
//  public final static int OFF_INT = Integer.MAX_VALUE;
//  public final static int FATAL_INT = 50000;
//  public final static int ERROR_INT = 40000;
//  public final static int WARN_INT  = 30000;
//  public final static int INFO_INT  = 20000;
//  public final static int DEBUG_INT = 10000;
//    //public final static int FINE_INT = DEBUG_INT;
//  public final static int ALL_INT = Integer.MIN_VALUE;

//If priority is defined in log4j.properties, only the same or above priority message will be logged.

