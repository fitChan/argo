package com.myself.argo.withTaeHtun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CoupleBrownCony {
    //x-n는 +1, -1, *2
    //y-k 는 +1, +2, +3, +4 ,,,,,,,,,,+y[n-1]+1
    public static int bfs(int x, int y) {
        boolean[][] visited = new boolean[500001][2];
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        if (x == y) {
            return time;
        }
        q.add(new int[]{x, 0});
        int back, front, jump;
        int queue = 0;
        int nowX;
        int nowTime;
        int[] now;
        while(true){
            ++time;
            y = time+y; //전에 움직였던거 +해줘야 현재의 y가 될것임. 계속 움직이니까.

            if(y>500000){
                return -1;   //y는 계속 가는데 범위를 벗어나는 순간 못만나는 것으로 치고 -1 return;
            }
            if(visited[y][time%2]){
                return time;
            }
            queue = q.size();

            for(int i=0; i<queue; i++){
                now = q.poll();

                nowTime = (now[1]+1)%2;
                nowX = now[0];

                //여기서부터 bakc-1 front+1 jump*2 로 나누어서 계산을 진행할것. 각각 queue에 넣을 것임.

                back = nowX-1;       //-1할 경우
                if(back == y)return time;
                if(back>=0 && !visited[back][nowTime]){            //back 범위는 -1 이기 때문에 음수로 가지 않는지 채크
                    visited[back][nowTime] = true;
                    q.add(new int[]{back,nowTime});
                }

                front = nowX +1;      //+1 할 경우
                if(front == y)return time;
                if(front<=500000 && !visited[front][nowTime]){    //front의 범위는 +1 이기 때문에 500000을 넘기지 않는지 채크
                    visited[front][nowTime] = true;
                    q.add(new int[]{front,nowTime});
                }

                jump = nowX*2;        //*2 할 경우
                if(jump == y)return time;
                if(jump<=500000 && !visited[jump][nowTime]){      //jump의 범위는 *2 이기 때문에 500000을 넘기지 않는지 채크
                    visited[jump][nowTime] = true;
                    q.add(new int[]{jump,nowTime});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        bfs(x, y);
    }
}
