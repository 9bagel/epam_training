package com.epam.module_2.decomposition;

/*
. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
если угол между сторонами длиной X и Y— прямой.
 */
public class Task9 {
    public static void main(String[] args) {
        
    }

    private static double findRightTriangleSquare(int x, int y) {
        return 0.5 * x * y;
    }

    private static double findTetragonSquare(double x, double y, double z, double t) {
        double halfOfPerimeter = 0;
        double square = 0;

        halfOfPerimeter = (x + y + z + t) / 2;

        square = Math.sqrt((halfOfPerimeter - x) * (halfOfPerimeter - y) * (halfOfPerimeter - z) * halfOfPerimeter - t);

        return square;

    }
}
