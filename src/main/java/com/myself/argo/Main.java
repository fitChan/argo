package com.myself.argo;


public class Main {

    public static int[] solution(int[] arr) {
        int arrayNum[] = new int[4];
        for(int i=0; i<arr.length; i++){
            arrayNum[arr[i]]++;
        }
        int max = Integer.MIN_VALUE;

        for(int i=1; i<arrayNum.length; i++){
            if(arrayNum[i]>max){
                max = arrayNum[i];
            }
        }
        int one = max-arrayNum[1];
        int two = max-arrayNum[2];
        int three = max-arrayNum[3];
        int[] answer = {one, two, three};
        return answer;
    }
    public static void main(String[] args) {
         int arr[] = {1, 2, 3};

         solution(arr);


    }
}
