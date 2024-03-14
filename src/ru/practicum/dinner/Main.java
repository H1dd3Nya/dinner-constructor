package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static ArrayList<String> dishTypes;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu(); //Вызов меню программы
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();//Вызов функции добавления блюда
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() { // Меню программы
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() { // Метод добавления нового блюда
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addTypeAndDish(dishType, dishName); // Вызов метода addTypeAndDish класса DinnerConstructor
    }

    private static void generateDishCombo() { // Метод генерации комбо-обедов
        System.out.println("Начинаем конструировать обед...");
        dishTypes = new ArrayList<>();

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) { // Получние списка типов блюд
            dishTypes.add(nextItem);
            nextItem = scanner.nextLine();
        }

        dc.combosGenerator(numberOfCombos, dishTypes); // Вызов метода combosGenerator класса DinnerConstructor

    }
}
