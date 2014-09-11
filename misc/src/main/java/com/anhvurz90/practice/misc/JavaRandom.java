/*
 * Copyright (C) 2003-2014 eXo Platform SAS.
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
package com.anhvurz90.practice.misc;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Sep 11, 2014  
 */
public class JavaRandom {
  public static void main(String[] args) {
    System.out.format("ThreadLocalRandom: %d\n", ThreadLocalRandom.current().nextInt(10));
    System.out.format("Random: %d\n", new Random().nextInt(100));
    System.out.format("Math.random(): %f\n", Math.random());
  }
}
