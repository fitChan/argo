package com.myself.argo.programmers.lv2;

import java.util.*;

public class PairDelete {
    public static int solution(String s) {
        int answer = -1;
        StringBuilder sb = new StringBuilder(s);
        while(true){
            boolean check = true;

            for(int i=0; i<sb.length()-1; i++){
                if(sb.charAt(i) == sb.charAt(i+1)){
                    sb.delete(i, i+1);
                    check = false;
                    break;
                }
            }
            if(sb.length() == 0 || check){
                break;
            }
        }

        if(sb.length() == 0){
            answer = 1;
        }else {
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        solution(s);

    }
}
