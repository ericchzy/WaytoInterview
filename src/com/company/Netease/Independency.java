package com.company.Netease;

/**
 * Version 1
 * case通过率为60.00%, 未通过的测试例子 2 17 20 1 对应输出 10， 错误输出 12
 * 错误分析： 代码实际上是通过增加可以卖出手中的苹果这一条件来实现，但是题目条件并没有给出
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

        int TotalBalance = Balance + AppleNum * ApplePrice;
        int TotalCostPerDay = rentPrice + CostApplePerDay * ApplePrice;

        System.out.println(TotalBalance / TotalCostPerDay);

    }
}


