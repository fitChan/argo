package com.myself.argo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1149 {
    static int n = 0;
    static int R = 0;
    static int G = 1;
    static int B = 2;
    static int[][] price;
    static int[][] DP;

    public static int solution(int testCase, int color) {
        if (DP[testCase][color] == 0) {
            if (color == R) {
                DP[testCase][R] = Math.min(solution(testCase - 1, G), solution(testCase - 1, B)) + price[testCase][R];
            } else if (color == G) {
                DP[testCase][G] = Math.min(solution(testCase - 1, B), solution(testCase - 1, R)) + price[testCase][G];
            } else if (color == B) {
                DP[testCase][B] = Math.min(solution(testCase - 1, G), solution(testCase - 1, R)) + price[testCase][B];
            }
        }
        return DP[testCase][color];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        price = new int[n][3];
        DP = new int[n][3];
        for (int i = 0; i < n; i++) {
            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
            price[i][2] = sc.nextInt();
        }

        DP[0][R] = price[0][R];
        DP[0][G] = price[0][G];
        DP[0][B] = price[0][B];

        System.out.println(Math.min(solution(n - 1, R), Math.min(solution(n - 1, G), solution(n - 1, B))));

    }
}
