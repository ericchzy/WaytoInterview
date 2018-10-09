package Meituan;

import java.util.*;

public class Coupon {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            int n = in.nextInt(), target = in.nextInt(), sum = 0;
            int price[] = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = in.nextInt();
                sum += price[i];
            }

            if (sum < target) {
                System.out.println("-1");
                continue;
            }

            //背包情境：尽可能多放，相当于从差值中去掉没必要加入的菜品
            int m = sum - target;
            int[] dp = new int[m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = m; j >= 0; j--) {
                    if (price[i] > j) break;//该菜品必须添加
                    dp[j] = Math.max(dp[j - price[i]] + price[i], dp[j]);
                }
            }
            System.out.println(sum - dp[m]);
        }
    }
}

