package com.myself.argo.programmers.lv1;

public class KeyPadButton {
    public static int distane(int a) {
        int num = 0;
        if (a == 0) {
            num = 0;
        } else if (a % 2 == 0 && a < 8) { //  2,4,6 차이
            num = 2;
        } else if (a < 4 && a % 2 == 1) { // 1 , 3 차이
            num = 1;
        } else if (a > 4 && a % 2 == 1 && a<11) { //7, 9 차이
            num = 3;
        } else if (a == 8 || a == 10) {  // 8 10 차이
            num = 4;
        } else if (a == 11) {  // 11차이
            num = 5;
        }
        return num;
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int lh = 10;
        int rh = 12;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                lh = numbers[i];
                answer.append("L");
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                rh = numbers[i];
                answer.append("R");
            } else {
                if (distane(Math.abs(numbers[i] - lh)) > distane(Math.abs(numbers[i] - rh))) {
                    answer.append("R");
                    rh = numbers[i];
                } else if (distane(Math.abs(numbers[i] - lh)) < distane(Math.abs(numbers[i] - rh))) {
                    answer.append("L");
                    lh = numbers[i];
                } else if (distane(Math.abs(numbers[i] - lh)) == distane(Math.abs(numbers[i] - rh))) {
                    if (hand.equals("left")) {
                        answer.append("L");
                        lh = numbers[i];
                    } else if (hand.equals("right")) {
                        answer.append("R");
                        rh = numbers[i];
                    }
                }
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        solution(numbers, hand);
    }
}
