package Xiaomi;

import java.util.Arrays;
import java.util.Scanner;

public class TelAlias {
    static String[] tar = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE" };
    // 0 2 4 6 8 7 5 3 9 1
    static char[] ch = { 'Z', 'W', 'U', 'X', 'G', 'S', 'F', 'H', 'I', 'O' };
    static int num[] = { 0, 2, 4, 6, 8, 7, 5, 3, 9, 1 };

    public static void main(String[] args) {
        solve();
    }


    /**
     *在原始的NUM_STRING中，所有的数字中有的数字对应的大写字母只出现一次
     *如：ZERO的Z,TWO的W，FOUR的U，SIX的X，EIGHT的G，所以上一步统计的字符个数中如果这些字符的数量大于0，那么就说明
     *其对应的数一定存在，比如说如果Z出现3次，那么+8后的数字0一定有3个，也就是说原始数据2的个数为3
     *如果Z出现3次，那么我们就可以把ZERO所包含的Z，E，R，O先剔除
     *同理依次剔除只含W的TWO 的T,W,O
     *Z,W,U,X,G对应的剔除完后，剩余的NUM_STRING中O T F又是有的数字对应的大写字母只出现一次
     *再依次剔除他们，同理接下来的剔除顺序是 S I
     *当这样剔除后chNum中每个字符对应的个数都为0
     */
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        String tel;
        for (int i = 0; i < t; i++) {
            tel = scanner.nextLine();
            int cnt[] = new int[26];
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < tel.length(); j++) {
                cnt[tel.charAt(j) - 'A']++;
            }
            for (int j = 0; j < 10; j++) {
                int nc = cnt[ch[j] - 'A'];
                for (int k = 0; k < nc; k++) {
                    sb.append((num[j] + 2) % 10);
                }
                String ta = tar[num[j]];
                for (int k = 0; k < ta.length(); k++) {
                    cnt[ta.charAt(k) - 'A'] -= nc;
                }
            }
            char[] cs = sb.toString().toCharArray();
            Arrays.sort(cs);
            System.out.println(cs);
        }
    }
}