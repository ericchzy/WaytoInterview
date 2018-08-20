package com.company;

import java.util.Scanner;

/** 动态规划
 *
 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。

 5
 8 4
 3 6 9
 7 2 9 5

 例子中的最优方案是：5 + 8 + 6 + 9 = 28

 Input
 第1行：N，N为数塔的高度。(2 <= N <= 500)
 第2 - N + 1行：每行包括1层数塔的数字，第2行1个数，第3行2个数......第k+1行k个数。数与数之间用空格分隔（0 <= A[i] <= 10^5) 。
 4
 5
 8 4
 3 6 9
 7 2 9 5

 Output
 输出最大值
 28
 */

public class NOD51_1002_NumTower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long max = 0;
        int[][] dp = new int[n][n];  //存放路径的距离数组
        dp[0][0] = in.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = in.nextInt();
                if (j == 0)
                    // 一层中的最右端的特殊情况的处理代码
                    dp[i][j] = dp[i - 1][j] + num;
                else
                    // 对一层中的每一个数求上一层相邻(数组表示中的左上和正上方)两个数最大和(即最大路径)
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
