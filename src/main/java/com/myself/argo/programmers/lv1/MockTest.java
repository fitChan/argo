package com.myself.argo.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MockTest {
    public static int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] score = {0,0,0};
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length; i++){
            if(one[i % 5] == answers[i]){ score[0]++;}
            if(two[i % 8] == answers[i]){ score[1]++;}
            if(three[i % 10] == answers[i]){ score[2]++;}
        }
        int[] arr = new int[score.length];
        for(int i = 0; i < score.length; i++){
            arr[i] = score[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(score[i] == arr[2]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for(int i=0; i<5; i++){
            a[i] = sc.nextInt();
        }
        solution(a);

    }
}
