package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error one = new Error(true, 2000, "I like it");
        one.printInfo();
        Error two = new Error(false, 863, "Show must go on");
        two.printInfo();
        Error three = new Error(true, 55, "Here we go again");
        three.printInfo();
    }
}

