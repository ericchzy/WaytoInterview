package SF;

import java.util.Scanner;

public class EditDistance {
    /**
     * Compute edit distance between two string
     * @param strA original string
     * @param strB target string
     * @return edit distance
     */
    public static int editDistance(String strA, String strB){

        if (strA == null || strB == null) throw new RuntimeException("Invalid Input!");

        // define the edit cost
        int insDistance = 1, delDistance =1, repDistance = 1;

        int m = strA.length();
        int n = strB.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) dp[0][i] = i*insDistance;
        for (int i = 1; i <= m; i++) dp[i][0] = i*delDistance;


        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                int distance1 = dp[x-1][y] + delDistance;
                int distance2 = dp[x][y-1] + insDistance;
                int distance3 = 0;

                if(strA.charAt(x-1) == strB.charAt(y-1)) distance3 = dp[x-1][y-1];
                else distance3 = dp[x-1][y-1] + repDistance;

                dp[x][y] = Math.min(Math.min(distance1, distance2), distance3);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String strA = sc.next();
            String strB = sc.next();

            int cost = editDistance(strA, strB);
            System.out.println(cost);
        }

        sc.close();
    }
}

/* Output:
abcd
acc

3
*///:~