package com.myself.argo.withTaeHtun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class CoupleBrownCony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cony = sc.nextInt();
        int brown = sc.nextInt();
        int[] pos = new int[200001];

        int answer = -1;

        Queue<Integer> q = new LinkedList<>();
        q.add(brown);

        while (true) {
            int num = q.poll();

            int time = pos[num];
            int conyMove = 0;
            for (int i = 1; i <= time; i++) {
                conyMove += i;
            }
            if (num == cony + conyMove) {
                answer = pos[num];
                break;
            }

            int next = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = num - 1;
                } else if (i == 1) {
                    next = num + 1;
                } else {
                    next = num * 2;
                }

                if (next >= 0 && next < 200001 && pos[next]== 0) {
                    q.add(next);
                    pos[next] = pos[num]+1;
                }
            }
        }

        System.out.println();
        System.out.println(answer);
    }
}
