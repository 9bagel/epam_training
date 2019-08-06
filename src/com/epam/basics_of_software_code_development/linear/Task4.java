package com.epam.basics_of_software_code_development.linear;

/*
Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
дробную и целую части числа и вывести полученное значение числа.
 */
public class Task4 {
    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        double num = 123.456;

        double fraction = (num * 1000) % 1000;
        double integer = ((int) num) * 0.001;

        System.out.println(integer + fraction);
    }
}
