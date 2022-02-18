package com.myself.argo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class A2164 {
    public static int solution(int n){
        Deque<Integer> q = new LinkedList<>();

        for(int i=n; i>0; i--){
            q.add(i);
        }
        while(q.size()>1){
            q.pollLast();

            int tmp = q.pollLast();
            q.offerFirst(tmp);
        }

        int answer = q.poll();

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }
}
