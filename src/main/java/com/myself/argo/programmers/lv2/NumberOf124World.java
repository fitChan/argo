package com.myself.argo.programmers.lv2;

import java.util.Scanner;

public class NumberOf124World {
    public static String solution(long n) {
        String[] express124 = {"4", "1", "2"};
        String answer = "";
        long count = 0;
        while (n != 0) {
            count = n % 3;
            n = n/3;
            if(count == 0){
                n--;
            }
            answer = express124[(int) count] + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        //n을 -> 124로 표현하는 과정을 만들 거임.
        solution(n);
    }
}
