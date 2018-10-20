package JD;

import java.util.Scanner;


/**
 * @Link to Leetcode 205 Isomorphic Strings
 */
public class SimilarString {

    //利用模版每个字符与第一个字符的绝对值来获取题目给出的固定模式
    //再利用滑动窗口匹配原始字符
    private static int solve(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return 0;
        }
        int similarNum = 0;

        char[] cAs = s.toCharArray();
        char[] cAt = t.toCharArray();

        int[] window = new int[cAt.length - 1]; //记录矢量的窗口
        int winLength = cAt.length;

        int windowIndex = 0;
        for (int i = 1; i < cAt.length; i++) {
            window[windowIndex++] = cAt[i] - cAt[0];
        }

        for (int i = 0; i < cAs.length; i++) {
            // 终止条件

            if ((i + winLength) > cAs.length) break;

            int[] cmpWindow = new int[cAt.length - 1];  //记录比较矢量的窗口
            int index = 0;

            for (int j = i + 1; j < (i + winLength); j++) {
                cmpWindow[index++] = Math.abs(cAs[j] - cAs[i]);
            }

            if (compareWindows(window, cmpWindow)) similarNum++;
        }

        return similarNum;

    }

    private static boolean compareWindows(int[] window1, int[] window2) {
        boolean result = true;
        int index = 0;
        for (int element : window1) {
            if (element != window2[index++]) result = false;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }
//        _S = "ababcb";
//        _T = "xyx";

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}
