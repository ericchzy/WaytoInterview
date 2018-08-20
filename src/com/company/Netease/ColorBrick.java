package com.company.Netease;

import java.util.HashSet;
import java.util.Scanner;

public class ColorBrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        HashSet<String> colorSet = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            colorSet.add(string.substring(i, i + 1));

            if (colorSet.size() > 2) {
                System.out.println("0");
                return;
            }
        }
        System.out.println(colorSet.size());
    }
}
