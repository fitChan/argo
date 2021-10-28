package com.myself.argo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1697 {
    static int n;
    static int k;
    static int[] count = new int[10001];


    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        count[n] = 1;
        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < 3; i++) {
                int temp;
                if (i == 0) {
                    temp = current + 1;
                } else if (i == 1) {
                    temp = current - 1;
                } else {
                    temp = current * 2;
                }

                if (temp == k) {
                    System.out.println(count[current]);
                    return;
                }
                if(temp<count.length && temp>=0 && count[temp] == 0){
                    q.add(temp);
                    count[temp] = count[current]+1;
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if(n==k){
            System.out.println(0);
        }
        else {
            bfs();
        }
    }
}