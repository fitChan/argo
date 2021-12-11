package com.myself.argo.programmers.lv1;

import java.util.Scanner;

public class MockTest {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        return answer;
    }
    public static void main(String[] args) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for(int i=0; i<5; i++){
            a[i] = sc.nextInt();
        }
        solution(a);

    }
}
