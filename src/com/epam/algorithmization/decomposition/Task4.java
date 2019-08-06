package com.epam.algorithmization.decomposition;

/*
На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class Task4 {
    public static void main(String[] args) {
        //Рандомное число точек
        int n = (int) (Math.random() * 100);
        int[][] dotes = new int[n][2];

        initializeCoordinates(dotes);

        double maxDistance = findMaxDistance(dotes);

        System.out.println(maxDistance);
    }

    private static double findMaxDistance(int[][] dotes) {
        double maxDistance = 0;

        for (int i = 0; i < dotes.length - 1; i++) {
            double tmpDistance = 0;
            int[] a = dotes[i];
            int[] b = dotes[i + 1];

            tmpDistance = Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));

            if (tmpDistance > maxDistance) {
                maxDistance = tmpDistance;
            }
        }

        return maxDistance;
    }

    private static void initializeCoordinates(int[][] dotes) {

        for (int i = 0; i < dotes.length; i++) {
            for (int j = 0; j < dotes[i].length; j++) {
                dotes[i][j] = (int) (Math.random() * 100);
            }
        }
    }
}
