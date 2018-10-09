package Meituan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Havel_Hakimi {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int groupNum = in.nextInt();
        while (groupNum-- > 0) {
            int length = in.nextInt();
            Integer[] seq = new Integer[length];
            for (int i = 0; i < length; i++) {
                seq[i] = in.nextInt();
            }
            if (deGraph(seq, length)) System.out.print("Yes");
            else System.out.print("No");
        }
    }

    private static boolean deGraph(Integer[] seq, int length) {
        for (int i = 0; i < length - 1; i++) {
            Arrays.sort(seq, i, length, Collections.reverseOrder());
            System.out.println(Arrays.toString(seq));
            if (i + seq[i] >= length) return false;

            for (int j = i + 1; j <= i + seq[i] ; j++) {
                --seq[j];
                if(seq[j] < 0) return false;
            }
        }
        if (seq[length - 1] != 0) return false;
        return true;
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        while (T-- > 0) {
//            int n = in.nextInt();
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                sum += in.nextInt();
//            }
//            System.out.println(sum == 2 * (n - 1) ? "Yes" : "No");
//        }
//    }
}