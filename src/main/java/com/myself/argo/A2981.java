package com.myself.argo;

import java.util.Scanner;

public class A2981 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc= sc.nextInt();
        int[] n=new int[tc];
        for(int i=0; i<tc;i++){
            n[i]=sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i=0; i<tc; i++){
            if(n[i]<min){
                min = n[i];
            }
        }

    }
}
