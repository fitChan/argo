package com.myself.argo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Dot {
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class A1278{

    static int[][] miro;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void bfs(int x, int y) {
        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Dot d = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = d.x + dx[i];
                int ny = d.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (visited[nx][ny])
                    continue;

                if (miro[nx][ny] == 0)
                    continue;


                q.add(new Dot(nx, ny));
                visited[nx][ny] = true;
                miro[nx][ny] = miro[d.x][d.y] + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        sc.nextLine();

        miro = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(miro[n - 1][m - 1]);

        sc.close();
    }
}

