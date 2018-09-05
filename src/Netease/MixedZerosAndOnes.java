package Netease;

import java.util.Scanner;

public class MixedZerosAndOnes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.next();
            int maxLen = 1;
            int len = 1;
            for (int i = 1; i < str.length(); i++) {
//                System.out.println(str.charAt(i - 1) + " and " + str.charAt(i));
                if (str.charAt(i - 1) != str.charAt(i)) {
                    len++;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                } else {
                    /* reset parameter len when the MixedZerosAndOnes String is interrupted */
                    len = 1;
                }
            }
            System.out.println(maxLen);
        }
    }
}
