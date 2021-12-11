package com.myself.argo.programmers.lv1;

import java.util.Scanner;

public class InnerProduct {
    public static int solution(int[] a, int[] b) {
        int answer = 0;
        int[] answerArr = new int[a.length];
        for(int i=0; i<a.length; i++){
            answerArr[i] = a[i] * b[i];
        }

        for(int i=0; i<answerArr.length; i++){
            answer+=answerArr[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[4];
        int[] b = new int[4];
        for(int i=0; i<a.length; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        solution(a,b);

    }
}
