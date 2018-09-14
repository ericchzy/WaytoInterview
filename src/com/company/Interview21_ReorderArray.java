package com.company;

import com.company.util.io;

public class Interview21_ReorderArray {
    private static int[] reorderArray(int[] numArray) {
        if (numArray == null || numArray.length <= 0)
            throw new RuntimeException("Input Number Array can't be NULL.");

        int indexPre = 0;
        int indexPost = numArray.length - 1;
        while (indexPre < indexPost) {

            // 向后移动indexPre, 直到它指向偶数
            while (indexPre < indexPost && numArray[indexPre] % 2 != 0) indexPre++;
            // 向前移动indexPost, 直到它指向奇数
            while (indexPre < indexPost && numArray[indexPost] % 2 == 0) indexPost--;

            if (indexPre < indexPost) swap(numArray, indexPre, indexPost);
        }

        return numArray;
    }

    private static void swap(int[] numArray, int num1, int num2) {
        int temp = numArray[num1];
        numArray[num1] = numArray[num2];
        numArray[num2] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("The original array: ");
        io.printIntegerArray(array1);
        System.out.print("The reorder array: ");
        io.printIntegerArray(reorderArray(array1));

        int[] array2 = {1, 2, 3, 4, 5};
        System.out.print("The original array: ");
        io.printIntegerArray(array2);
        System.out.print("The reorder array: ");
        io.printIntegerArray(reorderArray(array2));
    }
}

/* Output:
The original array: 0 1 2 3 4 5 6 7 8 9
The reorder array: 9 1 7 3 5 4 6 2 8 0
The original array: 1 2 3 4 5
The reorder array: 1 5 3 4 2
 *///:~
