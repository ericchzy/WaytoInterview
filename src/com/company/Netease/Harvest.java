package com.company.Netease;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] applesNums = new int[n];
        for (int i = 0; i < n; i++) {
            applesNums[i] = sc.nextInt();
        }

        int questionNum = sc.nextInt();
        int[] questions = new int[questionNum];

        for (int i = 0; i < questionNum; i++) {
            questions[i] = sc.nextInt();
        }

        int[] accumulateArray = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += applesNums[i];
            accumulateArray[i] = sum;
        }

        for (int i = 0; i < questionNum; i++) {
            System.out.println(binSearch(accumulateArray, questions[i]) + 1);
        }
    }

    private static int binSearch(int[] arr, int target) {
        int mid = arr.length / 2;

        if (arr[mid] == target) {
            return mid;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
