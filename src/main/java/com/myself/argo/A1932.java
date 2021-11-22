package com.myself.argo;

import java.util.Scanner;

public class A1932 {
    static int[][] arr;
    static Integer[][] dp;
    static int n;

    public static int solution(int x, int y) {
        if (x == n - 1)
            return dp[x][y];

        if (dp[x][y] == null) {
            dp[x][y] = Math.max(solution(x + 1, y), solution(x + 1, y + 1)) + arr[x][y];
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        System.out.println(solution(0, 0));


    }
}
