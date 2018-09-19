package com.company;

import java.util.ArrayList;
import java.util.List;

public class Interview57_TwoNumberOfSum {
    private static List<Integer> findNumbersWithSum(int[] data, int expectedSum) {
        List<Integer> result = new ArrayList<>(2);

        if (data == null || data.length < 2) return null;

        int smallIndex = 0;
        int bigIndex = data.length - 1;

        while (smallIndex < bigIndex) {
            if (data[smallIndex] + data[bigIndex] > expectedSum) bigIndex--;
            else if (data[smallIndex] + data[bigIndex] < expectedSum) smallIndex++;
            else {
                result.add(data[smallIndex]);
                result.add(data[bigIndex]);
                break;
            }
        }
        return result;
    }

    private static List<List<Integer>> findContinuousSequence(int expectedSum) {
        return null;
    }
    
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        int[] data1 = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumbersWithSum(data1, 15));

        int[] data2 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumbersWithSum(data2, 17));

        int[] data3 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumbersWithSum(data3, 10));
    }

    public static void test02(){
        System.out.println(findContinuousSequence(1));
        System.out.println(findContinuousSequence(3));
        System.out.println(findContinuousSequence(4));
        System.out.println(findContinuousSequence(9));
        System.out.println(findContinuousSequence(15));
        System.out.println(findContinuousSequence(100));
    }
}
