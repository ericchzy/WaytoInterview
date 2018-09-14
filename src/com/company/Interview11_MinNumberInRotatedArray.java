package com.company;

public class Interview11_MinNumberInRotatedArray {
    private static int MinNumberInRotatedArray(int[] numArray) {
        if (numArray == null || numArray.length <= 0)
            throw new RuntimeException("Input Number Array can't be NULL.");

        int indexPre = 0;
        int indexMid = indexPre;
        int indexPost = numArray.length - 1;


        while (numArray[indexPre] >= numArray[indexPost]) {

            if (indexPost - indexPre == 1) {
                indexMid = indexPost;
                break;
            }

            indexMid = (indexPre + indexPost) >> 1;

            if (numArray[indexPre] == numArray[indexPost]
                    && numArray[indexMid] == numArray[indexPre]) {
                return MidInOrder(numArray, indexPre, indexPost);
            }

            if (numArray[indexMid] >= numArray[indexPre]) {
                indexPre = indexMid;
            }

            if (numArray[indexMid] <= numArray[indexPost]) {
                indexPost = indexMid;
            }
        }

        return numArray[indexMid];
    }

    private static int MidInOrder(int[] numArray, int indexPre, int indexPost) {
        int result = numArray[indexPre];

        for (int i = indexPre + 1; i <= indexPost; i++) {
            if (result > numArray[i]) result = numArray[i];
        }

        return result;
    }

    public static void main(String[] args) {

        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(MinNumberInRotatedArray(array1));

        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(MinNumberInRotatedArray(array2));

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(MinNumberInRotatedArray(array3));

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(MinNumberInRotatedArray(array4));

        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(MinNumberInRotatedArray(array5));

        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(MinNumberInRotatedArray(array6));

        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(MinNumberInRotatedArray(array7));

        // 输入NULL
        System.out.println(MinNumberInRotatedArray(null));

    }
}


/* Output:

1
1
1
0
1
2
1
RuntimeException
 *///:~