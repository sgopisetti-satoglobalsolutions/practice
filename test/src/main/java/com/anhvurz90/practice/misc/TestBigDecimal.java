/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.practice.misc;

import java.math.BigDecimal;

public class TestBigDecimal {

    public static void main(String[] args) {
        double a = 1300d;
        double b = 700d;

        System.out.println((a - b) / 150);
        System.out.println(a / 150 - b / 150);

        BigDecimal a1 = new BigDecimal(a);
        BigDecimal b1 = new BigDecimal(b);

        BigDecimal b150 = new BigDecimal(150);

        BigDecimal a2 = a1.divide(b150, 20, BigDecimal.ROUND_UP);
        BigDecimal b2 = b1.divide(b150, 20, BigDecimal.ROUND_UP);

        System.out.println("BigDecimal: " + a2.subtract(b2).doubleValue());

        System.out.println(getHourMinuteRepresentation(a / 150 - b / 150));
        System.out.println(getHourMinuteRepresentation((a - b) / 150));

        System.out.println(new BigDecimal(12.3333).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());

    }

    private static double getHourMinuteRepresentation(final double time) {
        if (time < 0) {
            return (-1) * getHourMinuteRepresentation(-time);
        }
        BigDecimal bigDecimalTime = new BigDecimal(time);
        BigDecimal hour = new BigDecimal(bigDecimalTime.toBigInteger());
        BigDecimal bigDecimal60 = new BigDecimal(60);
        BigDecimal bigDecimal100 = new BigDecimal(100);
        BigDecimal minute = bigDecimalTime.subtract(hour).multiply(bigDecimal60).divide(bigDecimal100);
        return hour.add(minute).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

}
