package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passanger(int numbers) {
        System.out.println("Количество пассажиров в автобусе: " + numbers);
    }

    @Override
    public double fuel(double litres) {
        return litres * 62.2;
    }

}
