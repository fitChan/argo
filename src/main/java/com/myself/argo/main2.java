package com.myself.argo;

public class main2 {
    public static String solution(String[] log) {
        int[] hour = new int[log.length];
        int[] min = new int[log.length];

        for(int i=0; i<log.length; i++) {
            hour[i] = Integer.parseInt(log[i].split(":")[0]);
            min[i] = Integer.parseInt(log[i].split(":")[1]);
        }
        int[] totalMin = new int[log.length];
        int[] realTime = new int[log.length-1];
        for(int i=0; i<log.length; i++) {
            totalMin[i] = (hour[i]*60) + min[i];
        }
        int realTotal = 0;
        int realHour=0;
        int realMin=0;

        for(int i=0; i<log.length-1; i++){
            realTime[i] = totalMin[i+1]-totalMin[i];

            if(realTime[i]<5){
                realTime[i] = 0;
            }else if(realTime[i]>105){
                realTime[i] = 105;
            }
            realTotal += realTime[i];
        }

        realHour = realTotal/60;
        realMin = realTotal%60;

        if(realHour>9){
            if(realMin>9) {
                String answer = realHour + ":" + realMin;
                System.out.println(answer);
                return answer;
            }else{
                String answer = realHour + ":" +"0"+realMin;
                System.out.println(answer);
                return answer;
            }

        }else {
            if(realMin>9) {
                String answer = "0"+realHour + ":" + realMin;
                System.out.println(answer);
                return answer;
            }else{
                String answer = "0"+realHour + ":" +"0"+realMin;
                System.out.println(answer);
                return answer;

            }
        }



    }
    public static void main(String[] args) {
        String[] str ={"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        solution(str);

    }
}
