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

        BigDecimal a2 = a1.divide(b150);
        BigDecimal b2 = b1.divide(b150);

        System.out.println(a2.subtract(b2).toString());
    }
}
