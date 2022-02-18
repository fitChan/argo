package com.myself.argo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class A17298 {
    public static void solution(int n , int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[i] = -1;
            }else{
                answer[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int x: answer){
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(sc.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(sc.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, arr);
    }
}
