package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = right.split("/")[0].compareTo(left.split("/")[0]);
        return rsl != 0 ? rsl : left.compareTo(right);
    }
}