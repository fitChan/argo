package com.myself.argo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Toma {
    int x, y, z, day;

    public Toma(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}

public class A7569 {
    static int m; //가로
    static int n; //세로
    static int h; //높이
    static int[][][] box;
    static int sum = 0;
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    private static boolean check() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void bfs() {
        Queue<Toma> t = new LinkedList<>();
        int day = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 1) {
                        t.add(new Toma(k, j, i, 0));
                    }
                }
            }
        }

        while (!t.isEmpty()) {
            Toma toma = t.poll();
            day = toma.day;
            for (int i = 0; i < 6; i++) {
                int nx = toma.x + dx[i];
                int ny = toma.y + dy[i];
                int nz = toma.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= m || ny >= n || nz >= h)
                    continue;
                if (box[nz][ny][nx] != 0)
                    continue;

                t.add(new Toma(nx, ny, nz, day + 1));
                box[nz][ny][nx] = 1;
            }
        }
        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        sc. nextLine();
        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = sc.nextInt();

                }
            }
        }

        bfs();

    }
}
