package Bilibili;

import java.util.Scanner;

public class ClockwiselyPrintMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        int width = in.nextInt();
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = in.nextInt();
                System.out.println(matrix[i][j]);
            }
        }
        int endM = in.nextInt();
        int endN = in.nextInt();
//        int endM = -1;
//        int endN = -1;
        in.close();

        System.out.println("endM & endN: " + endM + " " + endN);
        printMatrixClockwisely(matrix, endM, endN);
    }

    private static void printMatrixClockwisely(int[][] matrix, int endM, int endN) {
        if (matrix == null) {
            return;
        }
        int columns = matrix[0].length;
        int rows = matrix.length;
        int start = 0;

        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(matrix, columns, rows, start, endM, endN);
            ++start;
        }
    }

    private static void printMatrixInCircle(int[][] matrix, int columns, int rows, int start, int endM, int endN) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // Print the matrix from left to right
        // Notice the equal symbol
        // Notice the 2rd and 3rd step the start point
        for (int i = start; i <= endX; i++) {
//            if (start == endM && i == endN) {
//                System.out.print(matrix[start][i]);
//                return;
//            }
            if (earlyStop(start, i, endM, endN, endX, endY)) {
                System.out.print(matrix[start][i]);
                return;
            }
            printNumber(matrix[start][i]);
        }

        // Print the matrix from top to bottom
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
//                if (i == endM && endX == endN) {
//                    System.out.print(matrix[i][endX]);
//                    return;
//                }
                if (earlyStop(i, endX, endM, endN, endX, endY)) {
                    System.out.print(matrix[i][endX]);
                    return;
                }
                printNumber(matrix[i][endX]);
            }
        }

        // Print the matrix from right to left
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
//                if (endY == endM && i == endN) {
//                    System.out.print(matrix[endY][i]);
//                    return;
//                }
                if (earlyStop(endY, i, endM, endN, endX, endY)) {
                    System.out.print(matrix[endY][i]);
                    return;
                }
                printNumber(matrix[endY][i]);
            }
        }

        // Print the matrix from bottom to top
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
//                if (i == endM && start == endN) {
//                    System.out.print(matrix[i][start]);
//                    return;
//                }
                if (earlyStop(i, start, endM, endN, endX, endY)) {
                    System.out.print(matrix[i][start]);
                    return;
                }
                printNumber(matrix[i][start]);
            }
        }

    }

    private static void printNumber(int number) {
        System.out.print(number + ",");
    }

    private static boolean earlyStop(int positionX, int positionY, int endM, int endN, int endX, int endY) {
        return (positionX == endM && positionY == endN) || (positionX == endX && positionY == endY);
    }
}
