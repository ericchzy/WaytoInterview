package Tencent;

import java.util.Scanner;

public class Triangle{
    private static int triangleNum(int n, int[] sticks) {
        if (n <= 0 || sticks == null) return 0;

        int result = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++)
                for (int k = j + 1; k <= n - 1; k++) {
                    if ((sticks[i] + sticks[j]) > sticks[k]
                            && (sticks[i] + sticks[k]) > sticks[j] && (sticks[j] + sticks[k]) > sticks[i])
                        result++;

                }
        }

        return result;
    }
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);

        int N = sc.nextInt();
        int[] sticksNum = new int[N];
        int[][] a = new int[N][10];
        for (int i = 0; i < N; i++) {
            sticksNum[i] = sc.nextInt();
            for (int j = 0; j < sticksNum[i]; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(triangleNum(sticksNum[i], a[i]));
        }
    }
}
