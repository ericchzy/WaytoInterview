package com.company;

import java.util.Scanner;

public class Expression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        char[] exprCharArray = expression.toCharArray();


        for (Character character: exprCharArray){
            System.out.println(character);
        }
    }
}
