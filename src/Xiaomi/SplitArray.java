package Xiaomi;

import java.util.Scanner;

public class SplitArray {
    private static int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return (int) binary(nums, m, sum, max);
    }

    private static long binary(int[] nums, int m, long high, long low) {
        long mid = 0;
        while (low < high) {
            mid = (high + low) / 2;
            if (valid(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static boolean valid(int[] nums, int m, long max) {
        int cur = 0;
        int count = 1;
        for (int num : nums) {
            cur += num;
            if (cur > max) {
                cur = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(splitArray(arr, m));
    }
}