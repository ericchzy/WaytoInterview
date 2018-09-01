package com.company;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

 * (1)boolean不是占1位，计算机处理处理数据的最小单元是1字节，一般1位的话，其余7位会被0补齐。
 * (2)在java虚拟机规范中，JVM没有用于操作boolean的字节码指令，在编译后用int的数据类型代替boolean，此时boolean占4字节。
 * (3)boolean[]数组编译后会被byte[]数组代替，此时的boolean占1字节。
 * 总结:boolean单独存在占4字节，在boolean[]中占1字节。
 **/

public class Interview03_Duplication {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        //利用“在一个长度为n的数组里的所有数字都在0到n-1的范围内”这一条件

        if (numbers == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        boolean[] numExistence = new boolean[length];
        for(int index = 0; index < length; index++) {
            if(numExistence[numbers[index]] == true) {
                duplication[0] = numbers[index];
                return true;
            }
            numExistence[numbers[index]] = true;
        }
        return false;
    }

    public static boolean duplicateSwapVersion(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] duplication = new int[1];

        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(duplicateSwapVersion(numbers1, 5, duplication));

        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(duplicateSwapVersion(numbers2, 5, duplication));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplicateSwapVersion(numbers3, 5, duplication));

        int[] numbers4 = {2, 1, 3, 0, 4};
        System.out.println(duplicateSwapVersion(numbers4, 5, duplication));

//        不符合题目要求的测试用例
        int[] numbers5 = {2, 1, 3, 5, 4};
        System.out.println(duplicateSwapVersion(numbers5, 5, duplication));
    }
}


/* Output:
true
true
true
false
false
*///:~