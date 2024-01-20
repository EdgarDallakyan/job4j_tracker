package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pavlov123@mail.ru", "Pavlov Igor Ivanovich");
        map.put("pogbaturin@yandex.ru", "Debrov Egor Petrovich");
        map.put("lunatik7169@gmail.com", "Rebrov Artem Sergeevich");
        map.put("pavlov123@mail.ru", "Paramonov Ivan Victorovich");
        map.put("leomessi@gmail.com", "Melomed Leonid Andreevich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
