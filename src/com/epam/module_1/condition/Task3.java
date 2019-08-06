package com.epam.module_1.condition;

/*
Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
 */

public class Task3 {
    public static void main(String[] args) {
        solution(1, 2, 3, 4, 5, 3);
    }

    private static void solution(int x1, int y1, int x2, int y2, int x3, int y3) {
        if ((x3 - x1) / (x2 - x1) == (y3 - y1) / (y2 - y1)) {
            System.out.println("Лежат на одной прямой");
        } else System.out.println("Не лежат на одной прямой");
    }
}
