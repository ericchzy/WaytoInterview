package com.company;

public class Interview29_ClockwiselyPrintMatrix {
    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        printMatrixClockwisely(numbers);
        System.out.println();

        int[][] numbers2 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},

        };
        printMatrixClockwisely(numbers2);
        System.out.println();


        int[][] numbers3 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
        printMatrixClockwisely(numbers3);
        System.out.println();

        int[][] numbers4 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {16, 15, 14, 13, 12, 11, 10, 9}
        };
        printMatrixClockwisely(numbers4);
        System.out.println();


        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        printMatrixClockwisely(numbers5);
        System.out.println();

        int[][] numbers6 = {
                {0, 1},
                {15, 2},
                {14, 3},
                {13, 4},
                {12, 5},
                {11, 6},
                {10, 7},
                {9, 8}
        };
        printMatrixClockwisely(numbers6);
        System.out.println();


        int[][] numbers7 = {
                {1, 2},
                {4, 3}
        };
        printMatrixClockwisely(numbers7);
        System.out.println();

        int[][] numbers8 = {
                {1}
        };
        printMatrixClockwisely(numbers8);
        System.out.println();

        // 0个元素的数组
        printMatrixClockwisely(new int[][]{{}});
        // printMatrixClockwisely(null);空数组

    }

    private static void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int columns = matrix[0].length;
        int rows = matrix.length;
        int start = 0;

        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(matrix, columns, rows, start);
            ++start;
        }
    }

    private static void printMatrixInCircle(int[][] matrix, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // Print the matrix from left to right
        // Notice the equal symbol
        // Notice the 2rd and 3rd step the start point
        for (int i = start; i <= endX; i++) {
            printNumber(matrix[start][i]);
        }

        // Print the matrix from top to bottom
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                printNumber(matrix[i][endX]);
            }
        }

        // Print the matrix from right to left
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                printNumber(matrix[endY][i]);
            }
        }

        // Print the matrix from bottom to top
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                printNumber(matrix[i][start]);
            }
        }

    }

    private static void printNumber(int number) {
        System.out.print(number + " ");
    }
}

/* Output:
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40
1 2 3 4 5 6 7 8
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
1 2 3 4 5 6 7 8
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 2 3 4
1
*///:~
