package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class OptimalStrategyForAGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        optimalStrategy(a);
    }

    public static void optimalStrategy(int[] arr){
        int[][] dp = new int[arr.length][arr.length];
        for(int g=0;g<dp.length;g++){ // iteration wrt to gaps
            for(int i=0,j=g;j<dp.length;j++,i++){
                if(g==0){ // if gap is equal to 1 , put the same value
                    dp[i][j]=arr[i];
                }else if(g==1){ // if gap is equal to 2 , put the maximum value
                    dp[i][j]=Math.max(arr[i],arr[j]);
                }else{ //
                    int val1 = arr[i]+Math.min(dp[i+2][j],dp[i+1][j-1]);
                    int val2 = arr[j]+Math.min(dp[i][j-2],dp[i+1][j-1]);
                    int val = Math.max(val1,val2);
                    dp[i][j]=val;
                }
            }
        }

        System.out.println(dp[0][arr.length-1]);
    }
}
