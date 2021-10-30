package com.myself.argo;

import java.util.Scanner;

public class A1149 {

    static int[][] houseColor;
    static int[][] DP;
    static int testCase;
     static int Red = 0;
     static int Green = 1;
     static int Blue = 2;

    public static int sum(int testCase, int color){
        if(DP[testCase][color] == 0 ){
            if(color == Red){
                DP[testCase][Red] = Math.min(sum(testCase-1, Green), sum(testCase-1, Blue)) + houseColor[testCase][Red];
            }else if(color == Green){
                DP[testCase][Green] = Math.min(sum(testCase-1, Red), sum(testCase-1, Blue)) + houseColor[testCase][Green];
            }else if(color == Blue){
                DP[testCase][Green] = Math.min(sum(testCase-1, Red), sum(testCase-1, Green)) + houseColor[testCase][Blue];
            }
        }return DP[testCase][color];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();
        houseColor = new int[testCase][3];
        DP = new int[testCase][3];

        for(int i=0; i<testCase; i++) {
            houseColor[i][0] = sc.nextInt();
            houseColor[i][1] = sc.nextInt();
            houseColor[i][2] = sc.nextInt();
        }
        DP[0][Red] = houseColor[0][Red];
        DP[0][Green] = houseColor[0][Green];
        DP[0][Blue] = houseColor[0][Blue];

        System.out.println(Math.min(sum(testCase-1, Red), Math.min(sum(testCase-1, Green), sum(testCase-1, Blue))));

    }
}
