package com.myself.argo.codility;

import java.util.Scanner;

public class task1 {
    static int N;
    static int[] array;
    static int max;
    public static int solution(int[] A, int[] B) {
        max = 0;
        for(int i=0; i<N; i++){
            array[A[i]] +=1;
            if(A[i] != B[i])
            array[B[i]] +=1;
        }
        for(int i=0; i<array.length; i++){
             max = Math.max(max, array[i]);
        }


        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            size = Math.max(size, A[i]);
            size = Math.max(size,B[i]);
        }
        array = new int[size+1];

        solution(A, B);
        System.out.println(max);
    }
}
