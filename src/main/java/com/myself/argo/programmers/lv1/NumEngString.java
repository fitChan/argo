package com.myself.argo.programmers.lv1;

public class NumEngString {
    public static int solution(String s) {
        int answer = 0;

        String[] engNum = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0; i<engNum.length; i++){
            s = s.replaceAll(engNum[i], String.valueOf(i) );
        }

        answer = Integer.parseInt(s);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String s = "2three45sixsevenninezero";
        solution(s);
    }
}
