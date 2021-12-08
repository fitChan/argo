package com.myself.argo.programmers.lv2;

import java.util.*;

public class NewsClusting {
    /*
문자열중 영문만 들어오도록 수정할것.
 이상한 특수문자 까지 들어오게 되는것이 문제의 원인
*/
    public static int solution(String str1, String str2) {
        int answer = 0;

        ArrayList<String> q1 = new ArrayList<>();
        ArrayList<String> q2 = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String spiltStr1 = str1.substring(i, i + 2);
            set.add(spiltStr1.toUpperCase());
            q1.add(spiltStr1.toUpperCase());
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String spiltStr2 = str2.substring(i, i + 2);
            set.add(spiltStr2.toUpperCase());
            q2.add(spiltStr2.toUpperCase());
        }

        double same = 0;
        for (int i = 0; i < q1.size(); i++) {
            if (q2.contains(q1.get(i))) {
                q1.remove(i);
                q2.remove(i);
                same++;
            }
        }
        double setSize = set.size();

        System.out.println(set);
        System.out.println(same);
        if (same == 0) {
            return 65536;
        }
        answer = (int) ((same / setSize) * 65536);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        solution(str1, str2);
    }
}

