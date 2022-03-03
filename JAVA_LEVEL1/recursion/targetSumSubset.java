package PEP.JAVA_LEVEL1.recursion;

import java.util.Scanner;

public class targetSumSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        printTargetSumSubset(arr,0,"",0,target);
    }

    private static void printTargetSumSubset(int[] arr, int idx, String set, int sum, int target) {
        if(idx==arr.length){
            if(sum==target){
                System.out.println(set+".");
            }
            return;
        }
        printTargetSumSubset(arr,idx+1,set+arr[idx],sum+arr[idx],target);
        printTargetSumSubset(arr,idx+1,set,sum,target);

    }
}
