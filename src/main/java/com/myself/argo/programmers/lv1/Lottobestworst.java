package com.myself.argo.programmers.lv1;

public class Lottobestworst {
    public static int prize(int a){
        if(a == 6){
            a = 1;
        }else if(a == 5){
            a =2 ;
        }else if(a == 4){
            a = 3;
        }else if(a == 3){
            a = 4;
        }else if(a == 2){
            a = 5;
        }else {
            a = 6;
        }
        return a;
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        boolean[] check = new boolean[6];
        int worst = 0;
        int best = 0;
        int zero = 0;
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j< lottos.length; j++){
                if(win_nums[i] == lottos[j] && !check[j]){
                    check[j] = true;
                }
            }
        }
        for(int i=0; i<6; i++){
            if(check[i]){
                worst++;
            }
        }
        for(int i=0; i<6; i++){
            if(lottos[i] == 0){
                zero++;
            }
        }

        best = zero + worst;
        prize(best);
        prize(worst);

        int[] answer = {prize(best), prize(worst)};
        return answer;
    }

    public static void main(String[] args) {
        //입출력 예시
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);
    }
}
