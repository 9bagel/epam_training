package com.epam.module_1.loop;

/*
 Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера
 */

public class Task6 {
    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        char c = 0;
        for (int i = 0; i < Character.MAX_VALUE; i++, c++) {
            System.out.println(c + " - " + "\\u" + (int) c);
        }
    }
}
