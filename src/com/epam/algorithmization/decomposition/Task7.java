package com.epam.algorithmization.decomposition;

public class Task7 {
    public static void main(String[] args) {
        System.out.println(findOddsFactorial());
    }

    private static int findOddsFactorial() {

        int factorialsSum = 0;
        for (int i = 1; i < 10; i++) {
            int fact = 1;
            if (i % 2 != 0) {
                for (int j = 1; j <= i; j++) {
                    fact *= j;
                }
                factorialsSum += fact;
            }
        }
        return factorialsSum;
    }

}
