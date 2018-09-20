package Xiaomi;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (str == null) return;

        String[] strings = str.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.print(strings[i] + " ");
        }
    }
}
