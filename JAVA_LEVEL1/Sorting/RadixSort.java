package PEP.JAVA_LEVEL1.Sorting;

import java.util.*;

public class RadixSort {

    public static void radixSort(int[] arr) {
        // write code here
        int max = Integer.MIN_VALUE;
        for(int val : arr)if(val>max)max=val;
        int exp =1;
        while(exp<=max){
            countSort(arr,exp);
            exp*=10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here
        // making frequency array
        int[] farr = new int[10];
        for(int i=0;i<arr.length;i++){
            farr[arr[i] / exp % 10]++;
        }
        // convert it into prefix sum array
        for(int i=1;i<farr.length;i++){  // it will convert it into a prefix sum array
            farr[i]+=farr[i-1];
        }
        // stable sorting by filling ans array

        int[] res = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int pos = farr[arr[i]/exp%10]-1;
            res[pos]=arr[i];
            farr[arr[i] / exp % 10]--;
        }
        // filling original array with the help of res array
        for(int i=0;i<arr.length;i++)arr[i]=res[i];
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }

}