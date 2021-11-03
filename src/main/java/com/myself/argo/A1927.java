package com.myself.argo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class A1927 {
    static int array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> q = new PriorityQueue<>(
                ((o1, o2) -> Math.abs(o1) == Math.abs(o2)? o1-o2:Math.abs(o1)-Math.abs(o2))
        );
        for (int i = 0; i < n; i++) {
            array = Integer.parseInt(br.readLine());
            if (array == 0) {
                if(!q.isEmpty()){
                    sb.append(q.poll()+"\n");
                }else{
                    sb.append("0\n");
                }
            }else {
                q.add(array);
            }
        }
        System.out.println(sb);
    }
}
