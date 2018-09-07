package com.company.Bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The input processing is wrong
 */

public class MouseEscape {
    private static List<Integer> wayDistance = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[][] map = new int[length][length];
/*        int x = 0, y = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] strings = line.split(",");
            for (String s: strings) System.out.println(s);
//            for (String s : strings) map[x][y++] = Integer.parseInt(s);
            x++;
        }*/

//        while (in.hasNextLine()) {
//            String string = in.nextLine();
//            for (String s :
//                    string.split(",")) {
//                System.out.print(s + " ");
//            }
//        }

//        for (int x = 0; x < length; x++) {
//            for (int y = 0; y < length; y++) {
//                map[x][y] = in.nextInt();
//            }
//        }

/*        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                System.out.print(map[x][y] + " ");
            }
        }*/


        dfs(map, 0, 0, 0);
        wayDistance.sort((o1, o2) -> o2 - o1);
        System.out.println(wayDistance.get(wayDistance.size() - 1));
    }

    //对一个位置的前进向下方向分别进行深度优先搜索
    private static void dfs(int[][] map, int i, int j, int distance) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) return;
        distance += map[i][j];  // 先加上当前位置再判断结束
        if ( i == map.length - 1 && j == map.length - 1) wayDistance.add(distance);
        dfs(map, i + 1, j, distance);
        dfs(map, i, j + 1, distance);
    }

}
