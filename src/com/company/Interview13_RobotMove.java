package com.company;

public class Interview13_RobotMove {
    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;

        boolean[] visited = new boolean[rows * cols];

        int startRow = 0;
        int startCol = 0;

        return movingCountCore(threshold, startRow, startCol, rows, cols, visited);
    }

    private static int movingCountCore(int threshold, int row, int col, int rows, int cols, boolean[] visited) {
        int count = 0;
        if (check(threshold, row, col, rows, cols, visited)) {
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(threshold, row - 1, col, rows, cols, visited)
                    + movingCountCore(threshold, row + 1, col, rows, cols, visited)
                    + movingCountCore(threshold, row, col - 1, rows, cols, visited)
                    + movingCountCore(threshold, row, col + 1, rows, cols, visited);

        }
        return count;

    }

    private static boolean check(int threshold, int row, int col, int rows, int cols, boolean[] visited) {
        return row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row * cols + col];
    }

    private static int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(15, 20, 20) + "[359]");
        System.out.println(movingCount(10, 1, 100) + "[29]");
        System.out.println(movingCount(10, 1, 10) + "[10]");
        System.out.println(movingCount(15, 100, 1) + "[79]");
        System.out.println(movingCount(15, 10, 1) + "[10]");
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(12, 1, 1) + "[1]");
        System.out.println(movingCount(-10, 10, 10) + "[0]");
    }

}
