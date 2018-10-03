package Bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MouseEscape {
    private static List<Integer> wayDistance = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[][] map = new int[length][length];
        for (int i = 0; i < length; i++) {
            String[] strArr = in.next().split(",");
            // length & width is equal
            for (int j = 0; j < length; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }

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
