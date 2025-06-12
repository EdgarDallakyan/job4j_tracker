package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("Name")
                .rules("Rule1")
                .rules("Rule2")
                .rules("Rule3")
                .build();
        System.out.println(permission);
    }
}