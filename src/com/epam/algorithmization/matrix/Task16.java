package com.epam.algorithmization.matrix;
/*
 Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
...,
2
n
так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
собой. Построить такой квадрат. Пример магического квадрата порядка 3:
 */


public class Task16 {
    public static void main(String[] args) {
        solution(10);
    }

    private static void solution(int n) {
        int[][] matrix;

        if (n % 4 == 0) {
            matrix = magicSquareDoublyEven(n);
        } else if (n % 2 == 0) {
            matrix = evenMagicSquare(n);
        } else {
            matrix = oddMagicSquare(n);
        }
        displaySquare(matrix);
    }

    private static int[][] oddMagicSquare(int n) {
        int magicConst = (n * (n * n + 1)) / 2;
        int num = 1;
        int row;
        int col;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

//Следующие числа (2,3,4 и так далее по возрастанию) записывайте в ячейки по правилу: одна строка - вверх, один столбец - вправо.
/*
Если вы вылезли за верхний предел квадрата, напишите цифру в самой нижней ячейке соответствующего столбца.
Если вы вылезли за правый предел квадрата, напишите цифру в самой дальней (левой) ячейке соответствующей строки.
Если вы попали на ячейку, которая занята другой цифрой, напишите цифру непосредственно под предыдущей записанной цифрой.
 */
        row = n / 2;
        col = n - 1;
        while (num <= n * n) {

            if (row < 0 && col >= n) {
                row = 0;
                col = n - 2;
            } else {
                if (row < 0) {
                    row = row + n;
                } else if (col >= 0) {
                    col = col % n;
                }

            }
            if (matrix[row][col] != 0) {
                row = row + 1;
                col = col - 2;
                continue;
            } else {
                matrix[row][col] = num++;
            }
            row = row - 1;
            col = col + 1;
        }
        return matrix;
    }

    private static int[][] magicSquareDoublyEven(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 4 * i + j + 1;
            }
        }
        for (int i = 0; i < n / 4; i++) {
            for (int j = 0; j < n / 4; j++) {
                matrix[i][j] = n * n + 1 - matrix[i][j];
            }
        }
        for (int i = 0; i < n / 4; i++) {
            for (int j = 3 * n / 4; j < n; j++) {
                matrix[i][j] = n * n + 1 - matrix[i][j];
            }
        }
        for (int i = 3 * n / 4; i < n; i++) {
            for (int j = 0; j < n / 4; j++) {
                matrix[i][j] = n * n + 1 - matrix[i][j];
            }
        }
        for (int i = 3 * n / 4; i < n; i++) {
            for (int j = 3 * n / 4; j < n; j++) {
                matrix[i][j] = n * n + 1 - matrix[i][j];
            }
        }
        for (int i = n / 4; i < 3 * n / 4; i++) {
            for (int j = n / 4; j < 3 * n / 4; j++) {
                matrix[i][j] = n * n + 1 - matrix[i][j];
            }
        }
        return matrix;
    }

    private static void displaySquare(int[][] square) {
        int n = square.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(square[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    private static int[][] evenMagicSquare(int n) {
        if (n == 2) {
            System.out.println("Не существует магического квадрата с порядком 2");
            //System.exit(0);
            int number = 1 + (int) (Math.random() * (n * n) + 1);
            int[][] square = new int[n][n];
            for (int indexX = 0; indexX < n; indexX++)
                for (int indexY = 0; indexY < n; indexY++)
                    square[indexX][indexY] = number;
            return square;
        }
        int[][] square = new int[n][n];
        int[][] quarter;
        quarter = oddMagicSquare(n / 2);

        //for top left quarter square
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                square[i][j] = quarter[i][j];
                square[n / 2 + i][n / 2 + j] = quarter[i][j] + (n * n) / 4;
                square[i][n / 2 + j] = quarter[i][j] + (n * n) / 2;
                square[n / 2 + i][j] = quarter[i][j] + 3 * (n * n) / 4;
            }
        }
        int k = (n - 1) / 4;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = square[j][i];
                square[j][i] = square[j + n / 2][i];
                square[j + n / 2][i] = temp;
                if ((i + 1) < k) {
                    temp = square[j][n - i - 1];
                    square[j][n - i - 1] = square[j + n / 2][n - i - 1];
                    square[j + n / 2][n - i - 1] = temp;
                }
            }
        }

        //undo the unneccessary swap
        int temp = square[n / 4][k - 1];
        square[n / 4][k - 1] = square[3 * n / 4][k - 1];
        square[3 * n / 4][k - 1] = temp;

        //swap the diagonal elements
        temp = square[n / 4][k];
        square[n / 4][k] = square[3 * n / 4][k];
        square[3 * n / 4][k] = temp;

        return square;
    }
}


