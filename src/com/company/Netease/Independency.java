package com.company.Netease;

/**
 * Version 1
 * case通过率为60.00%, 未通过的测试例子 2 17 20 1 对应输出 10， 错误输出 12
 * 错误分析： 代码实际上是通过增加可以卖出手中的苹果这一条件来实现，但是题目条件并没有给出
 * Version 2
 * case通过率为70.00%, 未通过的测试例子 1 1996245611 1999990159 123 对应输出 1996275808， 错误输出 -12660506
 * 错误分析：int TotalBalance 数值溢出
 * Version 3
 * 正确
 */

import java.util.Scanner;

public class Independency {
    public static final int CostApplePerDay = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rentPrice = scanner.nextInt();
        int AppleNum = scanner.nextInt();
        int Balance = scanner.nextInt();
        int ApplePrice = scanner.nextInt();

        /* Deal with the shortage of the Balance */
        if (AppleNum >= (Balance / rentPrice)) {
            System.out.println((Balance / rentPrice));
        } else {
            /* Deal with the shortage of the Apple */
            System.out.println(AppleNum + (Balance - AppleNum * rentPrice) / (ApplePrice + rentPrice));
        }

        scanner.close();

    }
}


