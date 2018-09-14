package com.company;

public class Interview04_FindInSortedMatrix {
    private static boolean findInMatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length < 1 ||  matrix[0].length < 1) return false;

        boolean result = false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0;
        int column = columns - 1;

        while (column >= 0 && row <= rows - 1) {

            if (matrix[row][column] == k) {
                result = true;
                break;
            }

            if (matrix[row][column] > k) column--;
            else row++;
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(findInMatrix(matrix, 7));    // 要查找的数在数组中
        System.out.println(findInMatrix(matrix, 5));    // 要查找的数不在数组中
        System.out.println(findInMatrix(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println(findInMatrix(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println(findInMatrix(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println(findInMatrix(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println(findInMatrix(null, 16));     // 健壮性测试，输入空指针
    }
}


/* Output:
true
false
true
true
false
false
false
 *///:~