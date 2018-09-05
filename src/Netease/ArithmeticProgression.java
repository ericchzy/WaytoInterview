package Netease;

import java.util.Arrays;
import java.util.Scanner;

public class ArithmeticProgression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = sc.nextInt();
        }

        Arrays.sort(sequence);
        int d = sequence[1] - sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if ((sequence[i] - sequence[i - 1]) != d) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

}
