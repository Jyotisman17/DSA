package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(mcm(arr));
    }

    public static int mcm(int[] arr){
        int[][] dp = new int[arr.length-1][arr.length-1];

        for(int g=0;g<dp.length;g++){
            for(int i=0,j=g;j<dp.length;j++,i++){
                if(g==0)dp[i][j]=0; // when we are multiplying a single matrix
                else if(g==1){ // when we are multiplying two matrix
                    dp[i][j]=arr[i]*arr[j]*arr[j+1];
                }else{
                    int min  = Integer.MAX_VALUE;
                    for(int k = i;k<j;k++){
                        // i - k : left half , k+1 - j : right half

                        int lc = dp[i][k];
                        int rc = dp[k+1][j];

                        int mc = arr[i]*arr[k+1]*arr[j+1];

                        int tc = lc+rc+mc;

                        if(tc<min)min=tc;

                    }

                    dp[i][j]=min;
                }
            }

        }

        return dp[0][dp.length-1];
    }
}
