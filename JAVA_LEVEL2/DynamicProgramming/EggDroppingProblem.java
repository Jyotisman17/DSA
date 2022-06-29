package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class EggDroppingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int f = sc.nextInt();
        System.out.println(eggDrop(e,f));
    }

    public static int eggDrop(int n,int k){
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(i==1)
                    dp[i][j]=j;
                else if(j==1)
                    dp[i][j]=1;
                else{
                    int min = Integer.MAX_VALUE;
                    // now we will calculate the main part of this problem
                    for(int mj=j-1,pj=0;mj>=0;mj--,pj++){
                        int v1=dp[i][mj];
                        int v2=dp[i-1][pj];
                        int max  = Math.max(v1,v2);
                        min = Math.min(max,min);
                    }
                    dp[i][j]=min+1;
                }
            }
        }
        return dp[n][k];
    }
}
