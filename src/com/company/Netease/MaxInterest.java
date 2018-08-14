package com.company.Netease;

import java.util.Scanner;

public class MaxInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int[] sleep = new int[n];
        for (int i = 0; i < n; i++) {
            sleep[i] = sc.nextInt();
        }
        int sum = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (sleep[i] == 1) {
                sum += scores[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (sleep[i] == 0) {
                int temp = sum;
                for (int j = i; j < Math.min(i + k, n); j++) {
                    if (sleep[j] == 0) {
                        temp += scores[j];
                    }
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        System.out.println(max);
    }
}
