package com.epam.basics_of_software_code_development.condition;

/*
Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
он прямоугольным.

 */

public class Task1 {

    public static void main(String[] args) {
        solution(40, 70);
    }

    private static void solution(int a, int b) {
        int c = 180 - a - b;

        if (a + b < 180) {
            System.out.println("Треугольник существует");

            if (a == 90 || b == 90 || c == 90) {
                System.out.println("Треугольник прямоугольный");
            }

        } else System.out.println("Треугольник не существует");
    }
}
