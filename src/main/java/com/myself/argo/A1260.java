package com.myself.argo;

import java.util.*;

public class A1260 {
    static int n;
    static int m;
    static int v;
    static int[][] graph;
    static boolean[] check;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정점입력");
        n = sc.nextInt();
        System.out.print("간선입력");
        m = sc.nextInt();
        System.out.print("startNum 입력");
        v = sc.nextInt();
        graph = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            System.out.print("x입력");
            int x = sc.nextInt();
            System.out.print("y입력");
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(v);
        System.out.println();
        Arrays.fill(check, false);
        bfs(v);
        sc.close();
    }

    private static void dfs(int start) {
        check[start] = true;

        System.out.print(start + " ");

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = true;
        System.out.print(start+" ");
        while (!q.isEmpty()) {
            int vertex = q.poll();
            for (int i = 1; i < graph.length; i++) {
                if (graph[vertex][i] == 1 && !check[i]) {
                    q.offer(i);
                    check[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }
}