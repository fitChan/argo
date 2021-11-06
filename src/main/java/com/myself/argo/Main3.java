package com.myself.argo;

import java.util.Arrays;

public class Main3 {
    public static int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;

        String[] gre = new String[ings.length];
        int[] grePrice = new int[ings.length];
        for (int i = 0; i < ings.length; i++) {
            gre[i] = ings[i].split(" ")[0];
            grePrice[i] = Integer.parseInt(ings[i].split(" ")[1]);
        }


        String[] menuName = new String[menu.length];
        String[] greReady = new String[menu.length];
        int[] menuPrice = new int[menu.length];
        for (int i = 0; i < menu.length; i++) {
            menuName[i] = menu[i].split(" ")[0];
            greReady[i] = menu[i].split(" ")[1];
            menuPrice[i] = Integer.parseInt(menu[i].split(" ")[2]);
        }

        String[] realSell = new String[sell.length];
        int[] sellNum = new int[sell.length];
        for (int i = 0; i < sell.length; i++) {
            realSell[i] = sell[i].split(" ")[0];
            sellNum[i] = Integer.parseInt(sell[i].split(" ")[1]);
        }
        int[] totalGrePrice = new int[menu.length];

        for (int i = 0; i < menu.length; i++) {
            for (int j = 0; j < greReady[i].length(); j++) {
                for (int k = 0; k < ings.length; k++) {
                    char ctr = greReady[i].charAt(j);
                    String cts = String.valueOf(ctr);
                    if (cts.equals(gre[k])) {
                        totalGrePrice[i] += grePrice[k];
                    }
                }
            }
        }

        for (int i = 0; i < sell.length; i++) {
            for (int j = 0; j < menu.length; j++) {
                if (realSell[i].equals(menuName[j])) {
                    answer += (menuPrice[j] - totalGrePrice[j]) * sellNum[i];
                }
            }
        }
        System.out.println(answer);


        return answer;
    }

    public static void main(String[] args) {
        String[] ings = {"x 25", "y 20", "z 1000"};
        String[] menu = {"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
        String[] sell = {"BBBB 3", "TTT 2"};

        solution(ings, menu, sell);
    }
}
