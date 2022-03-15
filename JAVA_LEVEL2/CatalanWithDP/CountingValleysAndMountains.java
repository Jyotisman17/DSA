package PEP.JAVA_LEVEL2.CatalanWithDP;

import java.util.Scanner;

public class CountingValleysAndMountains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<dp.length;i++){
            int inside = i-1;
            int outside = 0;

            while(inside>=0){
                dp[i]+=dp[outside]+dp[inside];
                inside--;
                outside++;
            }
        }

        /*
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
         */

        System.out.println(dp[n]);
    }
}
