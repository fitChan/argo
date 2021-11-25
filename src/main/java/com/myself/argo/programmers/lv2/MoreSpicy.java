package com.myself.argo.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MoreSpicy {
    public static boolean sub(ArrayList<Integer> arr, int K) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < K) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < scoville.length; i++) {
            arr.add(scoville[i]);
        }
        Collections.sort(arr);
        while (true) {
            int smallest = arr.get(0);
            arr.remove(0);
            int secondSmallest = arr.get(0);
            arr.remove(0);

            if (smallest + (secondSmallest * 2) < K && arr.size() == 0) {
                answer = -1;
                break;
            }
            arr.add(smallest + (secondSmallest * 2));
            Collections.sort(arr);
            answer++;

            if (sub(arr, K)) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] scoville = new int[6];
        for (int i = 0; i < scoville.length; i++) {
            scoville[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        solution(scoville, k);
    }
}
