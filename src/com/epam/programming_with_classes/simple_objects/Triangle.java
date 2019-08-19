package com.epam.programming_with_classes.simple_objects;

/*
 Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
площади, периметра и точки пересечения медиан.
 */

public class Triangle {
    private int a;
    private int b;
    private int c;

    public static void main(String[] args) {

    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Создание равностороннего треугольника
    public Triangle(int a) {
        this.a = a;
        this.b = a;
        this.c = a;
    }

    private double findSquare() {
        double halfPerimeter = findPerimeter() / 2;
        double square = Math.sqrt(halfPerimeter * (halfPerimeter - this.a) * (halfPerimeter - b) * (halfPerimeter - c));

        return square;
    }

    private double findPerimeter() {
        return this.a + this.b + this.c;
    }

    private void findMedianCross() {
        double medianAB = Math.sqrt(2 * Math.pow(this.a, 2) + 2 * Math.pow(this.b, 2) - Math.pow(this.c, 2)) / 2;
        double medianBC = Math.sqrt(2 * Math.pow(this.b, 2) + 2 * Math.pow(this.c, 2) - Math.pow(this.a, 2)) / 2;
        double medianAC = Math.sqrt(2 * Math.pow(this.a, 2) + 2 * Math.pow(this.c, 2) - Math.pow(this.b, 2)) / 2;

        System.out.printf("Медиана AB = %f \n Медиана BC = %f \n Медиана AC = %f", medianAB, medianBC, medianAC);
    }
}
