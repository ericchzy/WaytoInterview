package Tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxabsOfSubSequence {
    private static int MaxCore(int[] sequence, int length, int changeableNum) {
        if (sequence == null || length < 0 || changeableNum < 0) throw new RuntimeException("Invalid Input!");
        int[] dp = new int[length];

        List<Integer> negetiveNumList = new ArrayList<>();
//        dp[0] = Math.abs(sequence[0]);
        dp[0] = sequence[0];
        for (int i = 1; i < length; i++) {
            if (sequence[i] < 0){
                negetiveNumList.add(Math.abs(sequence[i]));
            }
            dp[i] = Math.max(Math.abs(dp[i - 1] + sequence[i]), Math.abs(sequence[i]));


        }

        if (changeableNum > 0) {
            negetiveNumList.sort((o1, o2) -> o2.compareTo(o1));
            int index = 0;
            while (changeableNum != 0) {
                dp[dp.length - 1] += negetiveNumList.get(index++);
                changeableNum--;
            }
        }


        return dp[dp.length - 1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int length = sc.nextInt();
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = sc.nextInt();
        }
        int changeableNum = sc.nextInt();

        System.out.print(MaxCore(sequence, length, changeableNum));

    }
}
