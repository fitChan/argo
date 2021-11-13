package com.myself.argo.programmers.lv2;

public class ColorBook {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int eachNum = 0;
    public static void dfs(int x, int y, int[][] picture, boolean[][] visited){
        if(visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        eachNum++;

        for(int i=0; i<4; i++){
            int nx = x+ dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>= picture.length|| ny<0 || ny>= picture[0].length) continue;

            if(picture[x][y] == picture[nx][ny] && !visited[nx][ny]){
                dfs(nx, ny, picture, visited);
            }
        }

    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture,visited);
                }
                if(eachNum>maxSizeOfOneArea){
                    maxSizeOfOneArea = eachNum;
                }
                eachNum = 0;
            }
        }



        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;

        int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(m,n,pic);
    }
}
