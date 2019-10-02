package com.epam.basic_of_oop.dragon_cave;

import java.util.Scanner;

public class Main {
    private static final int TREASURE_COUNT = 100;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Вы победили дракона и нашли сокровища, да не одно а целых %d. Что будем делать с таким добром?"
                    + "\n 0 - Выход"
                    + "\n 1 - Просмотреть все сокровища"
                    + "\n 2 - Забрать самое дорогое"
                    + "\n 3 - Набрать сокровищ на определённую сумму\n", TREASURE_COUNT);

            int choice;


            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Это должно быть число 0, 1, 2 или 3");
                    scanner.next();
                }
                choice = scanner.nextInt();

                if (choice >= 0 && choice <= 3)
                    break;
            }

            Cave cave = new Cave(TREASURE_COUNT);
            cave.createTreasures();

            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    cave.printAllTreasures();
                    break;
                case 2:
                    cave.printMostExpensiveTreasure();
                    break;
                case 3:
                    System.out.println("На какую сумму будем брать?");
                    int sum;

                    while (true) {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Это должно быть число");
                            scanner.next();
                        }
                        sum = scanner.nextInt();

                        if (sum > 0) {
                            break;
                        } else System.out.println("Сумма должна быть > 0");
                    }
                    cave.printOnSum(sum);
                    break;
            }

        }
    }

}
