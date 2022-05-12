package PEP.JAVA_LEVEL2.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArrayWithSumZero {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        ArrayList<Integer> psv = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        int i=-1;
        int sum = 0;
        map.put(sum,i); // putting 0 @ -1th index

        while(i<arr.length-1){
            i++;
            sum+=arr[i];
            if(map.containsKey(sum)==false){
                map.put(sum,i);
            }else{
                int len = i - map.get(sum);
                if(len>maxLen)maxLen=len;
            }
        }
        return maxLen;
    }
}
