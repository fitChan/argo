package com.myself.argo.programmers.lv2;

import java.util.HashMap;

public class GroupPhotoShot {
    static String[] staticData;
    static HashMap<Character, Integer> map;
    static boolean[] visited;
    static int[] ch;
    static int answer;

    public static int solution(int n, String[] data) {
        staticData = data;
        map = new HashMap<>();
        visited = new boolean[8];
        ch = new int[8];
        answer = 0;
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);
        dfs(0);
        return answer;
    }
public static void dfs(int idx){
        if(idx == 8){
            if(satisfy()){
                answer++;
            }
        }else{
            for(int i=0; i<8; i++){
                if(!visited[i]){
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx+1);
                    visited[i] = false;
                }
            }
        }
}
    public static boolean satisfy() {
        int x, y, res;
        char c;
        for (String s : staticData) {
            x = ch[map.get(s.charAt(0))];
            y = ch[map.get(s.charAt(2))];
            c = s.charAt(3);
            res = s.charAt(4) - '0' + 1;

            if (c == '=') {
                if(Math.abs(x-y)!= res)
                    return false;
            }else if(c == '>'){
                if(Math.abs(x-y)<=res){
                    return false;
                }
            }else {
                if(Math.abs(x-y)>= res){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        solution(n, data);
    }
}
