package iqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 定理：从A={1,2,3,…,n}中取m个不相邻组合，其组合数为Cm(n−m+1)
 * 分别取各方案组合数即可
 */

public class MealSchemes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            data.add(i);
        }
        int result = 0;
        int n = data.size();
        for(int i = 1; i <= data.size(); i++)
            result += factorial(n - i + 1) / (factorial((n - i + 1) - i) * factorial(i));

        System.out.println(result + 1);

    }

    /**
     * Find the factorial of a number
     *
     * @param n : number to find the factorial
     * @return : factorial value of 'n'
     */
    public static int factorial(int n) {
        //1
        int fact = 1;
        //2
        for (int i = 1; i <= n; i++) {
            //3
            fact = fact * i;
        }
        //4
        return fact;
    }
}

