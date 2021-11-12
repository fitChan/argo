package com.myself.argo.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenChatRoom {
    public static String[] solution(String[] record) {

        Map<String, String> uid = new HashMap<>();
        ArrayList<String> nickname = new ArrayList<>();
        for (int i = record.length - 1; i >= 0; i--) {
            if (record[i].split(" ").length < 3) {
                continue;
            }
            if (!uid.containsKey(record[i].split(" ")[1])) {
                uid.put(record[i].split(" ")[1], record[i].split(" ")[2]);
            }
        }


        for (int i = 0; i < record.length; i++) {
            if (record[i].split(" ")[0].equals("Enter")) {
                nickname.add(uid.get(record[i].split(" ")[1]) + "님이 들어왔습니다.");

            } else if (record[i].split(" ")[0].equals("Leave")) {
                nickname.add(uid.get(record[i].split(" ")[1]) + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[nickname.size()];
        int i=0;
        for(String s : nickname){
            answer[i]=s;
            i++;
        }



        return answer;
    }


    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        solution(record);

    }

}
