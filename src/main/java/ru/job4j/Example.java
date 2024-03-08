package ru.job4j;

import java.util.*;

public class Example {
    public static void main(String[] args) {
        Integer[] numbers = {1, 1, 2, 3, 4};
        Map<Integer, Integer> unique = new HashMap<>();

        for (Integer number : numbers) {
            unique.put(number, unique.getOrDefault(number, 0) + 1);
        }

        Integer firstUniqueNumber = null;
        for (Integer number : numbers) {
            if (unique.get(number) == 1) {
                firstUniqueNumber = number;
                break;
            }
        }

        System.out.println("unique number: " + firstUniqueNumber);
    }
}
