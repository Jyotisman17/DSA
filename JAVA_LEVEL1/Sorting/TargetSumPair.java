package PEP.JAVA_LEVEL1.Sorting;

import java.util.*;

public class TargetSumPair {

    public static void targetSumPair(int[] arr, int target){
        //write your code here
        Arrays.sort(arr);
        int li = 0;
        int ri = arr.length-1;

        while(li<ri){
            int sum = arr[li]+arr[ri];
            if(sum<target){
                li++;
            }else if(sum>target){
                ri--;
            }else{
                System.out.println(arr[li] + ", "+ arr[ri]);
                li++;
                ri--;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr,target);
    }

}