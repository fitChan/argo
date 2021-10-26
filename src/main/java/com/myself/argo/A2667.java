package com.myself.argo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A2667 {
    static int N; //정사각형임. 가로세로 이거로.
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] house;
    static ArrayList<Integer> result;
    static int  sum;
    private static int dfs(int i, int j) {
        house[i][j] = 0;
        for (int x = 0; x < dx.length; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (house[nx][ny] == 1) {
                    dfs(nx, ny);
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        house = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                house[i][j] = sc.nextInt();
            }
        }
        sum = 0;
        result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (house[i][j] == 1) {
                    sum=1;
                    dfs(i, j);
                    result.add(sum);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());

        for(int c: result) System.out.println(c);
    }
}
