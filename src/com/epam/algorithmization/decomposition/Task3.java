package com.epam.algorithmization.decomposition;

/*
Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
треугольника.
 */

public class Task3 {
    public static void main(String[] args) {

    }

    private static double findTriangleSquare(int a) {
        return Math.sqrt(3) * Math.pow(a, 2) / 4;
    }

    private static double findHexagonSquare(int a) {
        return 6 * findTriangleSquare(a);
    }
}
