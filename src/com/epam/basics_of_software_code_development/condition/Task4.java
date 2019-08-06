package com.epam.basics_of_software_code_development.condition;

/*
 Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
отверстие.
 */
public class Task4 {
    public static void main(String[] args) {

    }

    private static void solution(int a, int b, int x, int y, int z) {

        if ((a < x) && (b < y) ||
                (a < x) && (b < z) ||
                (a < z) && (b < y)) {
            System.out.println("Кирпич пройдёт");

        } else System.out.println("Кирпич не пройдёт");
    }
}
