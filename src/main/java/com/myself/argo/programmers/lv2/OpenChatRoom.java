package com.myself.argo.programmers.lv2;

import java.util.ArrayList;

public class OpenChatRoom {
    public static String[] solution(String[] record) {
        String[] answer = new String[record.length];


        for (int i = record.length - 1; i >= 0; i--) {
            if (record[i].split(" ")[0].equals("Change")) {
                answer = new String[record.length-1];
            }
        }

        ArrayList<String> uid = new ArrayList<>();
        ArrayList<String> nickname = new ArrayList<>();
        for (int i = record.length - 1; i >= 0; i--) {
            if (!uid.contains(record[i].split(" ")[1])) {
                uid.add(record[i].split(" ")[1]);
                if (record[i].split(" ").length == 3) {
                    nickname.add(record[i].split(" ")[2]);
                }
            }
        }

        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < uid.size(); j++) {
                if (record[i].split(" ")[1].contains(uid.get(j))) {
                    if (record[i].split(" ")[0].equals("Enter")) {
                        answer[i] = "\""+nickname.get(j) + "님이 " + "들어왔습니다."+"\"";
                    } else if (record[i].split(" ")[0].equals("Leave")) {
                        answer[i] = "\""+nickname.get(j) + "님이 " + "나갔습니다."+"\"";
                    } else {
                        break;
                    }
                }
            }
        }
        for(String an :answer) {
            System.out.print(an);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        solution(record);

    }
}
