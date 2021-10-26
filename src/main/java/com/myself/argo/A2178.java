package com.myself.argo;

import java.util.Scanner;

public class A2178 {
    static int row;
    static int col;
    static int[][] graph;
    static boolean[] visited;
    static int[] px = {1, 0, 0, 0};
    static int[] py = {0, 1, 0, 0};
    static int[] my = {0, 0, 0, -1};
    static int sum;
    public static void dfs(int i, int j) {
        graph[i][j] = 0;
        for (int x = 0; x < px.length; i++) {
            int nx = i + px[x];
            int ny = j + py[x];
            int exception = j + my[x];

            if(nx>=0 && ny >= 0 && nx<row && ny<col){
                if(graph[nx][exception] == 1 && graph[nx][ny] == 0){
                    dfs(nx, exception);
                }else{
                    dfs(nx,ny);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        graph = new int[row][col];
        for(int i=0; i<row; i++){
           String input = sc.next();
            for(int j=0; j<col; j++){
                graph[i][j] = input.charAt(j)-'0';
            }
        }
        sum = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(graph[i][j] == 1)
                dfs(i,j);
                sum++;
            }
        }
        System.out.println(sum);

    }
}
