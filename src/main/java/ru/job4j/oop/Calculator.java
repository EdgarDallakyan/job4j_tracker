package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        int rslSum = Calculator.sum(10);
        System.out.println(rslSum);
        Calculator calculator = new Calculator();
        int rslMult = calculator.multiply(5);
        System.out.println(rslMult);
        int rslMin = Calculator.minus(6);
        System.out.println(rslMin);
        Calculator calculator1 = new Calculator();
        int rslDiv = calculator1.divide(35);
        System.out.println(rslDiv);
        Calculator calculator2 = new Calculator();
        int rslAll = calculator2.sumAllOperation(100);
        System.out.println(rslAll);
    }
}

