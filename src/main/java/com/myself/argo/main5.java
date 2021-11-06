package com.myself.argo;

import java.util.LinkedList;
import java.util.Queue;

public class main5 {
    static int currentX = 0;
    static int currentY = 0;

    public static int[][] solution(int rows, int columns) {
        int[][] graph = new int[rows][columns];
        if (rows == columns) {
            if (graph[0][0] > 1) {
                return graph;
            }
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (graph[i][j] != 0) {
                        return graph;
                    }
                }
            }
        }

        if (currentX == 0 && currentY == 0 && graph[currentX][currentY] == 0) {
            graph[currentX][currentY] = 1;
            currentY++;
            solution(currentX, currentY);
        }
        if (graph[currentX][currentY] % 2 != 0 && graph[currentX][currentY]>0) {
            if (currentY == columns-1) {
                graph[currentX][0] = graph[currentX][currentY] + 1;
                currentY = 0;
                solution(currentX, currentY);
            } else {
                graph[currentX][currentY + 1] = graph[currentX][currentY] + 1;
                currentY++;
            }
            solution(currentX, currentY);
        } else if (graph[currentX][currentY] % 2 == 0&&graph[currentX][currentY]>0) {
            if (currentX == rows-1) {
                graph[0][currentY] = graph[currentX][currentY] + 1;
                currentX = 0;
                solution(currentX, currentY);
            } else {
                graph[currentX + 1][currentY] = graph[currentX][currentY] + 1;
                currentX++;
                solution(currentX, currentY);
            }
        }


        int[][] answer = graph;
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(answer[j][i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int row = 3;
        int column = 4;

        solution(row, column);
    }

}
