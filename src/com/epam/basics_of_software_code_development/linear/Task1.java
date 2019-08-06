package com.epam.basics_of_software_code_development.linear;

import java.util.Scanner;

//Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.

public class Task1 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
//Scanner не закрываем, т.к. нет необходимости закрывать System.in
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.println(((a - 3) * b / 2) + c);
    }
}
