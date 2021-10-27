package com.myself.argo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
    int x, y, day;

    public Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class A7576 {
    static int M;//가로
    static int N;//세로
    static int[][] box; //box 판.
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean visited() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void bfs() {
        Queue<Tomato> q = new LinkedList<>();
        int day = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            day = tomato.day;
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                if (box[nx][ny] != 0)
                    continue;

                q.add(new Tomato(nx, ny, day + 1));
                box[nx][ny] = 1;
            }
        }

        if (visited()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        bfs();

        sc.close();
    }
}
