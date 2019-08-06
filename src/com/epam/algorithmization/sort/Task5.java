package com.epam.algorithmization.sort;

//Сортировка вставками
public class Task5 {
    public static void main(String[] args) {
        int[] firstArray = {1, 5, 8, 2, 18, 3, 15, 0, 10, 12};
        solution(firstArray);
    }

    private static void solution(int[] array) {
        int value;

        for (int index = 0; index < array.length; index++) {
            index = binarySearch(array, array[index]);
            value = array[index];
            array[index] = value;
        }

        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    private static int binarySearch(int[] array, int key) {
        int min = 0;
        int max = array.length;
        int mid;

        while (min < max) {

            mid = min + (max - min) / 2;

            if (array[mid] == key) {
                return mid;
            }

            if (key < array[mid]) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        return (1 + min) - 1;
    }

    //Реализация из этой статьи https://habr.com/ru/post/415935/
    private static void biner(int[] array) {
        int key;
        int max;
        int min;

        for (int i = 0; i < array.length; i++) {
            key = array[i];
            max = i;
            min = 0;

            while (min < max) {
                int mid = min + (max - min) / 2;
                if (key < array[mid]) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }

            for (int j = i; j >= min + 1; j--) {
                array[j] = array[j - 1];
            }
            array[min] = key;
        }

        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }
}

