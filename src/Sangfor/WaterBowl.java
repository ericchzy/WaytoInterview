package Sangfor;

import java.util.Scanner;

/**
 * 2
 * 3
 * 2 1 3
 * 3
 * 2 4 3
 *
 * output:
 *
 * 4
 * 5
 */

public class WaterBowl {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNum=in.nextInt();
        for (int i = 0; i < testNum; i++) {
            int length = in.nextInt();
            int[] map = new int[length];
            for (int j = 0; j < length; j++) {
                map[j] = in.nextInt();
            }
            boolean[] isVisited = new boolean[length];

            dfs(map, isVisited, 0, map[0]);

            int countExist = 0;
            for (int j = 0; j < length; j++) {
                if (map[j] != 0) countExist += map[j];
            }
            System.out.println(countExist);

        }
    }

    //对一个位置的两个方向分别进行深度优先搜索
    private static void dfs(int []map,boolean []isVisited,int i, int waterLevel){
        if(i<0||i>=map.length||isVisited[i]) return ;
        isVisited[i]=true;
        if(waterLevel<map[i]) return ;
        else map[i] = 0;  //将其摧毁
        dfs(map,isVisited,i+1, waterLevel);
        dfs(map,isVisited,i-1, waterLevel);
    }
}
