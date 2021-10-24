package com.myself.argo;

import java.util.Scanner;

public class A2606 {
    static boolean[] visited;
    static int[][] graph;
    static int sum;
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("컴퓨터의 갯수 : ");
        int computer = sc.nextInt();
        System.out.print("간선의 갯수 : ");
        int m = sc.nextInt();

        graph = new int[computer+1][computer+1];
        visited = new boolean[computer+1];
        for(int i=0; i<m; i++){
            System.out.print("x의값 입력 : ");
            int x = sc.nextInt();
            System.out.print("y의값 입력 : ");
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        sum = 0;
        dfs(1);

            System.out.println(sum);
    }

    public static void dfs(int start){

            visited[start] = true;

            for(int i=1; i<graph.length; i++){
                if(graph[start][i] ==1 && !visited[i]){
                    sum += 1;
                    dfs(i);
                }
            }


    }
}
