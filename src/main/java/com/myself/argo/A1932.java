package com.myself.argo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1932 {
    static int[][] arr;
    static int nx = 0;
    static int ny = 0;
    static int sum = 0;

    public static void solution(int n) {
        Queue<int[]> q = new LinkedList<>();
        int max = 0;
        q.add(new int[]{0, 0});
        sum = arr[0][0];
        while (!q.isEmpty()) {
            int[] nowNum = q.poll();
            if (nx < n) {
                nx++;
                for (int i = 0; i < 2; i++) {
                    ny = i + nowNum[1];
                    q.add(new int[]{nx, ny});
                }
                sum += arr[nx][ny];
                System.out.println(sum);
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution(n - 1);


    }
}
