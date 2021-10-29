package com.myself.argo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class spot{
    int x, y;
    int brw, count;

    public spot(int x, int y, int brw, int count) {
        this.x = x;
        this.y = y;
        this.brw = brw;
        this.count = count;
    }
}

public class A2206 {
    static int m;
    static int n;
    static int[][] graph;
    static boolean[][][] check;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void bfs(int x , int y){
        Queue<spot> q = new LinkedList<>();
        check[x][y][0] = true;
        check[x][y][1] = true;
        q.add(new spot(x,y, 0, 1));

        while(!q.isEmpty()){
            spot s = q.poll();
            if(s.x == n && s.y == m){
                System.out.println(s.count);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];
                int brw = s.brw;
                int count = s.count;

                if(nx<=0|| ny<=0|| nx>n || ny>m)
                    continue;
                if(graph[nx][ny] == 1){
                    if(brw == 0 && !check[nx][ny][1]){
                        check[nx][ny][1] = true;
                        q.add(new spot(nx,ny,1,count+1));
                    }
                }else{
                    if(!check[nx][ny][brw]){
                        q.add(new spot(nx,ny,brw,count+1));
                        check[nx][ny][brw] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new int[n+1][m+1];
        check = new boolean[n+1][m+1][2];

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        bfs(1, 1);
    }
}
