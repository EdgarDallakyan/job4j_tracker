package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> phoneContains = (phone) -> phone.getPhone().contains(key);
        Predicate<Person> nameContains = (name) -> name.getName().contains(key);
        Predicate<Person> surnameContains = (surname) -> surname.getSurname().contains(key);
        Predicate<Person> addressContains = (address) -> address.getAddress().contains(key);
        Predicate<Person> combine = phoneContains.or(nameContains).or(surnameContains).or(addressContains);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}