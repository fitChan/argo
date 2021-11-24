package com.myself.argo.programmers.lv2;

import java.math.BigInteger;
import java.util.Scanner;

public class PerfectSquare {
    public static long solution(long w, long h){
        long commonDivisor = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        long answer = w*h - (((w/commonDivisor)+(h/commonDivisor)-1)*commonDivisor);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long w = sc.nextInt();
        long h = sc.nextInt();
        solution(w,h);
    }
}
