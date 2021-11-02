package com.myself.argo.codility;

import java.util.ArrayList;
import java.util.Scanner;

public class binaryNum {
    static int N;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int[] maxZero;
    static int max;
    static int sum;
    public static int solution(int N) {
        max = 0;
        sum =0;
        while(N!=1){
            int binary = N%2;
            arrayList.add(binary);
            N = N/2;
        }
        maxZero = new int[arrayList.size()+1];
        int j=0;
        for(int i=arrayList.size()-1; i>=0; i--){

            if(arrayList.get(i) == 0){
                maxZero[j] ++;
            }else if(arrayList.get(i) == 1){
                j++;
            }

            sum = sum+arrayList.get(i);
        }

        for(int i=0; i<maxZero.length; i++){
            if(maxZero[i]>max){
                max = maxZero[i];
            }else if(sum == 0){
                max = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        while(N!=1){
            int binary = N%2;
            arrayList.add(binary);
            N = N/2;
        }
        solution(N);
        System.out.println(arrayList);
        System.out.println(sum+" "+max);
    }
}
