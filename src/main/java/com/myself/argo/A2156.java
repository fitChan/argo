package com.myself.argo;

import java.util.Scanner;

public class A2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int glass = sc.nextInt();
        int[] amount = new int[glass];
        int[] dp = new int[glass];
        for(int i=0; i<glass; i++){
            amount[i] = sc.nextInt();
        }
         dp[0]=amount[0] ;
        if(glass>1){
            dp[1] = amount[1]+amount[0];

            for(int i=3; i<glass; i++){
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+amount[i], dp[i-3]+amount[i-1]+amount[i]));
            }
        }
        System.out.println(dp[glass-1]);
    }
}
