package com.myself.argo;

import java.util.Scanner;

public class A10844 {
    final static long MOD = 1000000000;
    static Long[][] arr;
    public static Long solution(int position, int number) {
        if(position == 1){
            return arr[position][number];
        }

        if(arr[position][number]==null){
            if(number == 0){
                arr[position][number] = solution(position-1, 1);
            }else if(number == 9){
                arr[position][number] = solution(position-1, 8);
            }else{
                arr[position][number] = solution(position-1, number+1)+solution(position-1, number-1);
            }
        }
        return arr[position][number]%MOD;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr= new Long[n+1][10];

        for(int i=0; i<10; i++){
            arr[1][i] = 1L;
        }

        Long result = 0L;

        for(int i=1; i<=9; i++){
            result += solution(n,i);
        }
        System.out.println(result%MOD);

    }
}
