package PEP.JAVA_LEVEL1.DynamicProgramming;

import java.util.Scanner;

public class KnapSack_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];
        for(int i=0;i<vals.length;i++)
            vals[i]=sc.nextInt();
        for(int i=0;i<wts.length;i++)
            wts[i]=sc.nextInt();

        int cap = sc.nextInt();
        int[][] dp = new int[n+1][cap+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=wts[i-1]) {  // if sufficient balls exists
                    int rcap = j - wts[i - 1];

                    if (dp[i - 1][rcap] + vals[i - 1] > dp[i - 1][j])
                        dp[i][j] = dp[i - 1][rcap] + vals[i - 1];
                    else
                        dp[i][j] = dp[i - 1][j];// doesnot bat
                }else
                    dp[i][j]= dp[i-1][j];// doesnot bat
            }
        }
        System.out.println(dp[n][cap]);
    }


}
