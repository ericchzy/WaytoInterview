package Netease;

import java.util.Arrays;
import java.util.Scanner;

public class FindJob {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jobNum = in.nextInt();
        int friendNum = in.nextInt();
        int[][] jdArray = new int[jobNum][2];
        for (int x = 0; x < jobNum; x++) {
            jdArray[x][0] = in.nextInt();
            jdArray[x][1] = in.nextInt();
        }
        int[] ability = new int[friendNum];
        for (int x = 0; x < friendNum; x++) {
            ability[x] = in.nextInt();
        }
        process2(jdArray, ability);

    }

    private static void process2(int[][] jdArray, int[] ability) {
        // 按照工作难度升序排序
        Arrays.sort(jdArray, (int[] jd1, int[] jd2) -> {return jd1[0] - jd2[0];});

        // 更新每个工作的报酬为当前难度所能获取的最大报酬
        for (int i = 0; i < jdArray.length - 1; i++) {
            if (jdArray[i][1] > jdArray[i + 1][1]) {
                jdArray[i + 1][1] = jdArray[i][1];
            }
        }

        // 二分查找确定能胜任的最大工作难度及其最大报酬
        for (int i = 0; i < ability.length; i++) {
            int index = Arrays.binarySearch(jdArray, new int[] {ability[i], 0}, (int[] jd1, int[] jd2) ->{return jd1[0] - jd2[0];});
            index = index < 0 ? -(index + 1) - 1: index;
            System.out.println(index >= 0 ? jdArray[index][1] : 0);
        }

    }
}
