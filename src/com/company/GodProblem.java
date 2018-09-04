package com.company;

import java.util.Scanner;
import java.util.Stack;

public class GodProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();  // heigth for axis=0
        int width = sc.nextInt();  // width for axis=1
        int waterLevel = sc.nextInt();
        int[][] altitude = new int[height][width];
        boolean[][] floodMarked = new boolean[height][width];
        int ans = 0, x;

        System.out.println("height: " + height + "width: " + width + "waterLevel: " + waterLevel);

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                altitude[i][j] = sc.nextInt();
                if (waterLevel > altitude[i][j]) {
                    floodMarked[i][j] = true;
                } else {
                    floodMarked[i][j] = false;
                }
            }
        }

        process2(altitude, floodMarked, height, width);

    }

    // Check whether there is loop in `floodMarked` matrix
    public static void process2(int[][] altitude, boolean[][] floodMarked, int height, int width) {
        // The bowl shape is constructed by at least 3x3 in each dimension
        if (height < 3 || width < 3) {
            System.out.println("0");
        }

        boolean[] canGoDownPostionInLine = new boolean[width];
        Stack<Integer> canGoDownPostionInLineStack = new Stack<Integer>();

        // We can stop early for the last 3 elements
        for (int i = 0; i < (height - 3); i++) {
            for (int jForWidth = 0; jForWidth < width; jForWidth++) {

                int goDown = i + 1;
                if (floodMarked[goDown][jForWidth]) {
                    canGoDownPostionInLine[i] = true; // Forward
                    canGoDownPostionInLineStack.add(jForWidth);
                }
            }

            // We try to go down when position in line is permitted
            int currentjForWidth = canGoDownPostionInLineStack.pop();

        }
    }
}
