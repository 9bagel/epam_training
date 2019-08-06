package com.epam.module_2.matrix;

/*
 В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
пользователь с клавиатуры.
 */

import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) {
    }

    private static void solution(int[][] matrix) {
        int firstColumn = 0;
        int secondColumn = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер столбца, который будем менять");

        while (!scanner.hasNextInt()) {
            System.out.println("Это должно быть число");
            scanner.next();
        }
        firstColumn = scanner.nextInt();

        System.out.println("Введите номер второго столбца");

        while (!scanner.hasNextInt()) {
            System.out.println("Это должно быть число");
            scanner.next();
        }
        secondColumn = scanner.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            int tmp = matrix[i][firstColumn];
            matrix[i][firstColumn] = matrix[i][secondColumn];
            matrix[i][secondColumn] = tmp;
        }

    }
}
