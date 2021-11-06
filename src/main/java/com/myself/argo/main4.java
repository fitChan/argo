package com.myself.argo;

import java.util.ArrayList;

public class main4 {
    public static int[] solution(String s) {

        int size = s.length();
        String save = "";
        char current = s.charAt(0);
        int currentCount = 0;

        for(int i=0; i<size; i++){
            if(current == s.charAt(i)){
                ++currentCount;
            }else{
                save+=current;
                save+=currentCount;
                if(i+1>=size){
                    current=s.charAt(i);
                }else{
                    current=s.charAt(i+1);
                }
                currentCount=1;
            }
        }
        save += current;
        save += currentCount;
        System.out.println(save);

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        String s = "aaabbaaa";
        solution(s);
    }
}
