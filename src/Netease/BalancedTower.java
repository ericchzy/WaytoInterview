package Netease;

import java.util.Arrays;
import java.util.Scanner;

public class BalancedTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int towerNum = sc.nextInt();
        int opNum = sc.nextInt();
        int[][] towerHeight = new int[towerNum][2];
        for(int i = 0; i < towerNum; i++){
            towerHeight[i][0] = i+1;
            towerHeight[i][1] = sc.nextInt();
        }

        // Operation detail
        process2(towerNum, opNum, towerHeight);
    }

    private static void process2(int towerNum, int opNum, int[][] towerHeight) {
        int stability;
        int [][] operation = new int [opNum][2];

        // 按塔的高度排列
        Arrays.sort(towerHeight, (int[] height1, int[] height2) -> {return height1[1] - height2[1];});

//        for (int i = 0; i < towerHeight.length; i++) {
//            System.out.println("Tower number: " + towerHeight.length);
//            System.out.println(towerHeight[i][1]);
//        }

        for (int i = 0; i < opNum; i++) {
            Arrays.sort(towerHeight, (int[] height1, int[] height2) -> {return height1[1] - height2[1];});
            if (towerHeight[towerHeight.length - 1][1] > towerHeight[0][1]) {
                towerHeight[towerHeight.length - 1][1] -= 1;
                towerHeight[0][1] += 1;

                //搬移顺序 0表示来源 1表示去处
                operation[i][0] = towerHeight[towerHeight.length - 1][0];
                operation[i][1] = towerHeight[0][0];
            } else {
                System.out.println(0 + " " + i);
                for (int j = 0; j < i; j++) {
                    System.out.print(operation[j][0] + " " + operation[j][1]);
                }
                return;
            }
        }
        Arrays.sort(towerHeight, (int[] height1, int[] height2) -> {return height1[1] - height2[1];});
        stability = towerHeight[towerHeight.length - 1][1] - towerHeight[0][1];
        System.out.println(stability + " " + opNum);
        for (int i = 0; i < opNum; i++) {
            System.out.println(operation[i][0] + " " + operation[i][1]);
        }
    }
}


