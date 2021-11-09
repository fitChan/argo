package com.myself.argo.programmers.lv1;

import java.util.regex.Pattern;

public class NewIdRecommend {
    public static String solution(String new_id) {
        String answer = "";
        //소문자로
        answer = new_id.toLowerCase();
        //소문자, 숫자, - _ . 빼고 전부 삭제
        answer = answer.replaceAll("[^0-9a-z-_.]","");

        //.. .2이상 연속시 .으로 치환
        answer = answer.replaceAll("\\.{2,}","."); //{2}로하면 2개로 인식 2이상이므로 {2,0}

        // . 이 제일 앞, 뒤에 위치할 경우 삭제 ^\\. ->시작할때 |또는 \\.$ 끝날때
        answer = answer.replaceAll("^\\.|\\.$","");

        //길이가 0 -> 빈 문자열 -> a 로 치환
        answer = answer.length() == 0?"a":answer;

        //길이가 16이상 첫 15개 문자만 출력  이후 마지막이 . 이면 삭제
        answer = answer.length()>=16? answer.substring(0,15).replaceAll("\\.$",""):answer;

        //길이가 2 이하라면 마지막 문자를 3이 될때까지 반복해서 출력
        while(answer.length()<=2){
            answer += answer.substring(answer.length()-1, answer.length());

        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String new_id = "=.=";
        solution(new_id);
    }
}
