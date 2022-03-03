package PEP.JAVA_LEVEL1.DynamicProgramming;

import java.util.Scanner;

public class printStairs {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int cp = countPaths(n,new int[n+1]);
        int cp = countPathTab(n);
        System.out.println(cp);
    }
    public static int countPaths(int n,int[] qb){
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(qb[n]!=0)return qb[n];
        int nm1 = countPaths(n-1,qb);
        int nm2 = countPaths(n-2,qb);
        int nm3 = countPaths(n-3,qb);
        return qb[n] = nm1+nm2+nm3;

    }

    public static int countPathTab(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1];
            }else if(i==2){
                dp[i]=dp[i-1]+dp[i-2];
            }else
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}

