package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishList;
    ArrayList<String> dishes;
    Random rd;

    DinnerConstructor() {
        dishList = new HashMap<>();
        dishes = new ArrayList<>();
        rd = new Random();
    }

    boolean checkType(String type) {
        return dishList.containsKey(type);
    }

    void addTypeAndDish(String dishType, String dishName) {
        boolean typeIsExist = checkType(dishType);

        if (typeIsExist) {
            dishes = new ArrayList<>();
            dishes = dishList.get(dishType);
            dishes.add(dishName);
            dishList.put(dishType, dishes);
        } else {
            dishes.add(dishName);
        }

        dishList.put(dishType, dishes);
    }

    void combosGenerator (int numberOfCombos, ArrayList<String> dishTypes) {

    }
}
