package PEP.JAVA_LEVEL1.DynamicProgramming;

import java.util.Scanner;

public class PathWithMaximumGold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (j == arr[0].length - 1) {
                    dp[i][j]=arr[i][j];
                } else if (i == 0) {
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j+1])+arr[i][j];
                } else if (i == arr.length - 1) {
                    dp[i][j]=Math.max(dp[i][j+1],dp[i-1][j+1])+arr[i][j];
                } else {
                    dp[i][j]=Math.max(dp[i][j+1],Math.max(dp[i-1][j+1],dp[i+1][j+1]))+arr[i][j];
                }
            }
        }

        int max = dp[0][0];
        for(int i=1;i<dp.length;i++){
            if(dp[i][0]>max)max=dp[i][0];
        }

        System.out.println(max);
    }
}
