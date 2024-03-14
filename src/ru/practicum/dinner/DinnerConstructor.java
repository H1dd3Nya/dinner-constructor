package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishList; // Хэш-таблица для хранения типов блюд и списков блюд для этих типов
    Random rd;

    DinnerConstructor() {
        dishList = new HashMap<>();
        rd = new Random();
    }

    boolean checkType(String type) { // Проверка введённого типа на наличие в хэш-таблице
        return dishList.containsKey(type);
    }

    void addTypeAndDish(String dishType, String dishName) {
        boolean typeIsExist = checkType(dishType);
        ArrayList<String> dishes = new ArrayList<>();

        if (typeIsExist) {
            dishes = dishList.get(dishType);
            dishes.add(dishName);
        } else {
            dishes.add(dishName);
        }

        dishList.put(dishType, dishes);
    }

    void combosGenerator(int numberOfCombos, ArrayList<String> dishTypes) {
        ArrayList<String> combos;
        for (int i = 1; i <= numberOfCombos; i++) {
            combos = new ArrayList<>();
            for (String type : dishTypes) {
                int randomDish = rd.nextInt(dishList.get(type).size());
                combos.add(dishList.get(type).get(randomDish));
            }
            System.out.println("Комбо " + i);
            System.out.println(combos);
        }
    }
}
