package com.myself.argo.codility;

import java.util.Scanner;

public class uniquenum {
    static int[] arraySum;
    static int[] array;
    static int result ;
    static int[] A = new int[100001];

    public static int solution(int[] A) {
        result = 0;
        int length = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]>length){
                length = A[i];
            }
        }
        arraySum = new int[length+1];
        for(int i=0; i<A.length; i++){
            arraySum[A[i]] += 1;
        }
        for(int i=arraySum.length-1; i>=0; i--){
            if(arraySum[i] == 1){
                result = i;
                break;
            }else if(arraySum[i] != 1){
                result= -1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        solution(array);
        for(int i=arraySum.length-1; i>=0; i--){
            System.out.println(arraySum[i]);
        }
    }
}
