package com.myself.argo;


import java.util.Scanner;


public class A1904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] answer = new int[N + 1];

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }
        if (N == 2) {
            System.out.println(2);
            System.exit(0);
        }
        answer[1] = 1;
        answer[2] = 2;
        for (int i = 3; i <= N; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 15746;
        }

        System.out.println(answer[N]);
    }
}
