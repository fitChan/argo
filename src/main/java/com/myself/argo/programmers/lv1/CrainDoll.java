package com.myself.argo.programmers.lv1;

import java.util.ArrayList;

public class CrainDoll {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> box = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    box.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < box.size() - 1; ) {
            if (box.get(i).equals(box.get(i + 1))) {
                box.remove(i);
                box.remove(i);
                answer += 2;
                i = 0;
            } else {
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        solution(board, moves);
    }
}
