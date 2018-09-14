package com.company;

public class Interview53_NumAppearInOrderArray {
    public static int getNumberOfK(int [] array , int k) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }

        int firstK = getFirstK(array, k, 0, length - 1);
        int lastK = getLastK(array, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    private static int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return (getFirstK(array, k, start, mid - 1));
        } else if (array[mid] < k) {
            return (getFirstK(array, k, mid + 1, end));
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {
            //如果前面还有等于k的项说明此项不是第一个k项
            return (getFirstK(array, k, start, mid - 1));
        } else {
            return mid;
        }
    }

    private static int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;

        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data1, 3)); // 4

        // 查找的数组出现在数组的开头
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data2, 3)); // 4

        // 查找的数组出现在数组的结尾
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(getNumberOfK(data3, 3)); // 4

        // 查找的数字不存在
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data4, 2)); // 0

        // 查找的数字比第一个数字还小，不存在
        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data5, 0)); // 0

        // 查找的数字比最后一个数字还大，不存在
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data6, 0)); // 0

        // 数组中的数字从头到尾都是查找的数字
        int[] data7 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data7, 3)); // 4

        // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
        int[] data8 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data8, 4)); // 0

        // 数组中只有一个数字，是查找的数字
        int[] data9 = {3};
        System.out.println(getNumberOfK(data9, 3)); // 1

        // 数组中只有一个数字，不是查找的数字
        int[] data10 = {3};
        System.out.println(getNumberOfK(data10, 4)); // 0
    }
}
