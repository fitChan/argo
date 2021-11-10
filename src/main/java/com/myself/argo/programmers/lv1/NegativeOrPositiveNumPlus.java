package com.myself.argo.programmers.lv1;

public class NegativeOrPositiveNumPlus {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i< absolutes.length; i++){
            if(!signs[i]){
                absolutes[i] *= -1;
            }
            answer += absolutes[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {false,false,true};
        solution(absolutes, signs);
    }
}
