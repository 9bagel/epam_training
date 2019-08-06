package com.epam.module_1.linear;

/*
Вычислить значение выражения по формуле (все переменные принимают действительные значения):
𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦
𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦
∗ 𝑡𝑔 𝑥�
 */

public class Task3 {
    public static void main(String[] args) {
        solution(10, 20);
    }

    private static double solution(double x, double y) {
        return (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
    }
}
