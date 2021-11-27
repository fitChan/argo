package com.myself.argo.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MoreSpicy {


    public static int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for(int i=0; i<scoville.length; i++){
                heap.offer(scoville[i]);
            }

            while(heap.peek() < K){
                if(heap.size() < 2) return -1;
                int f1 = heap.poll();
                int f2 = heap.poll();

                int sco = f1 + (f2 * 2);
                heap.offer(sco);
                answer++;
            }

            return answer;
        }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] scoville = new int[6];
        for (int i = 0; i < scoville.length; i++) {
            scoville[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        solution(scoville, k);
    }
}
