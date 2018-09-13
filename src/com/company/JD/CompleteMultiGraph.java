package com.company.JD;

import java.util.Scanner;

public class CompleteMultiGraph {

    public static String isCover(int[][] edge, int N) {

        String s = "Yes";

        int[] sum = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {

            for (int j = 1; j < N + 1; j++) {

                sum[i] += edge[i][j];

            }

        }

        for (int i = 1; i < N + 1; i++) {

            for (int j = 1; j < N + 1; j++) {

                if (edge[i][j] == 0) {

                    if (sum[j] != sum[i]) s = "No";

                }

            }

        }

        return s;

    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T > 0) {

            int N = scan.nextInt();

            int M = scan.nextInt();

            int X, Y;

            int[][] edge = new int[N + 1][N + 1];

            for (int i = 0; i < M; i++) {

                X = scan.nextInt();

                Y = scan.nextInt();

                edge[X][Y] = 1;

                edge[Y][X] = 1;

            }

            String s = isCover(edge, N);

            System.out.println(s);

            T--;

        }

    }


}