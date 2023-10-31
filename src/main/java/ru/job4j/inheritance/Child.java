package ru.job4j.inheritance;

public class Child extends Parent {
    private String patronomic;

    public Child(String name, int age, String patronomic) {
        super(name, age);
        this.patronomic = patronomic;
    }

}
