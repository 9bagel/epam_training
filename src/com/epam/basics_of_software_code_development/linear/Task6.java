package com.epam.basics_of_software_code_development.linear;

/*
Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
принадлежит закрашенной области, и false — в противном случае
 */

public class Task6 {
    public static void main(String[] args) {
        solution(3, -3);
    }

    private static void solution(int x, int y) {
        if (x >= -4 && x <= 4 && y >= -3 && y <= 4)
            System.out.println("true");
        else System.out.println("false");
    }
}
