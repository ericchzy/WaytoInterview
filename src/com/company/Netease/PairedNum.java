package com.company.Netease;

import java.util.Scanner;

/**
 * 输入
 * 5 2
 * 输出
 * 7
 * 说明
 * 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 */

public class PairedNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong();
        long k=sc.nextLong();
        if(k == 0){
            System.out.println(n*n);
            return ;
        }

        long count = 0;  //记录找到的整数对个数
        long temp;
        //思路：固定y，找x
        for (long y = k + 1; y <= n; y++) {    //  x/y>=k,说明y>k
            // 假设n = a*y +b；在每个长度为y的区间里只有（y-k）个数模y余数>=k。
            count += n/y*(y-k); // `n/y` 为区间数
            temp = n%y;
            if(temp >= k) {                    //再考虑余数b是否>=k
                count += temp-k+1;              // 余数>=k 即有区间内有镜像数值对满足要求，如 y=3, (2,3),(5,3)
            }
        }
        System.out.println(count);
    }
}
