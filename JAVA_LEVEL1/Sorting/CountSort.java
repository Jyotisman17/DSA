package PEP.JAVA_LEVEL1.Sorting;

import java.util.*;

public class CountSort {

    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int range = max - min +1;
        int[] farr = new int[range];
        for(int i=0;i<arr.length;i++){
            farr[arr[i]-min]++;
        }
        for(int i=1;i<farr.length;i++){  // it will convert it into a prefix sum array
            farr[i]+=farr[i-1];
        }

        int[] res = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            res[farr[arr[i]-min]-1]=arr[i];
            farr[arr[i]-min]--;
        }
        for(int i=0;i<arr.length;i++)arr[i]=res[i];



    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr,min,max);
        print(arr);
    }

}