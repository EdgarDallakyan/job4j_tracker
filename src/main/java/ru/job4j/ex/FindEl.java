package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Такого элемента в массиве нет");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] values = {"Zero", "Five", "101", "1701"};
        try {
            int index = indexOf(values, "15");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}