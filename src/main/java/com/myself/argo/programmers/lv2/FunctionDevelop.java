package com.myself.argo.programmers.lv2;

import java.util.ArrayList;
import java.util.Scanner;

public class FunctionDevelop {
    static int[] progresses;
    static int[] speeds;
    static int[] days;

    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) {
                days[i] += 1;
            }
        }
        int sum = 1;
        int max = days[0];
        for (int i = 1; i < days.length; i++) {
            if (max < days[i]) {
                max = days[i];
                answer.add(sum);
                sum = 1;
                if (i == days.length - 1) {
                    answer.add(sum);
                }
            } else if (max >= days[i]) {
                sum++;
                if (i == days.length - 1) {
                    answer.add(sum);
                }
            }
        }
        for (int s : answer) {
            System.out.println(s);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        progresses = new int[n];
        speeds = new int[n];

        for (int i = 0; i < n; i++) {
            progresses[i] = sc.nextInt();
            speeds[i] = sc.nextInt();
        }
        solution(progresses, speeds);

    }
}
