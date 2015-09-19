/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.practice.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEach {

    public static void main(String[] args) {
        forEachMap();
        forEachList();
    }

    private static void forEachMap() {
        Map<Character, Integer> items = new HashMap<>();
        for (char c = 'A'; c <= 'F'; c++) {
            items.put(c, (c - 'A') * 10 + 10);
        }
        
        items.forEach((k, v) -> {
            System.out.format("Item: %c, Count: %d\n", k, v);
            if ('E' == k) {
                System.out.println("Hello E!");
            }
        });
    }

    private static void forEachList() {
        List<String> items = Arrays.asList(new String[] {"A", "B", "C", "D", "E"});

        System.out.println("Lamda: ------------------------");
        items.forEach(s -> System.out.println(s));
        System.out.println("Method Reference: ------------------------");
        items.forEach(System.out::println);
        System.out.println("Stream and filter------------------------");
        items.stream()
             .filter(s -> s.indexOf('B') >= 0)
             .forEach(System.out::println);

    }
}
