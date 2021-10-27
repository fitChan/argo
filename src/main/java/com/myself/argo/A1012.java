package com.myself.argo;

import java.util.Scanner;

public class A1012 {
    static int T; //test case
    static int M; // 가로길이
    static int N; // 세로 길이
    static int K; // 배추 갯수
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] graph;

    public static void dfs(int i, int j) {
        graph[i][j] = 0;
        for (int x = 0; x < dx.length; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (graph[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int sum = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            graph = new int[M][N];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x][y] = 1;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1) {
                        dfs(i, j);
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }


    }

}
