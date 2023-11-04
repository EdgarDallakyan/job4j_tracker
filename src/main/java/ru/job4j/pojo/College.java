package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Fodenov Fillip Ivanovich");
        student.setGroup(" № 3 ");
        student.setCreated(new Date());

        System.out.println(student.getFio() + " from group " + student.getGroup()
                + " entered: " + student.getCreated());
    }
}

