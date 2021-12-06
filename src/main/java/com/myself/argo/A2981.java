package com.myself.argo;

import java.util.Arrays;
import java.util.Scanner;

public class A2981 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] n = new int[tc];
        for (int i = 0; i < tc; i++) {
            n[i] = sc.nextInt();
        }

        Arrays.sort(n);

        int secondMin = n[0];
        int start = 2;
        while (true) {
            for (int i = 1; i < tc; i++) {
                if (n[i] % start == n[i-1] % start) {
                    return;
                }
            }
        }


    }
}
