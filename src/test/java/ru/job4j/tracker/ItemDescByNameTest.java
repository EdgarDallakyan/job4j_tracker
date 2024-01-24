package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void whenDescByName() {
        Item item1 = new Item("James");
        Item item2 = new Item("Richard");
        Item item3 = new Item("Larry");
        Item item4 = new Item("Jonathan");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(item2, item3, item4, item1);
        assertThat(items).isEqualTo(expected);
    }
}