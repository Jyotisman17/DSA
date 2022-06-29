package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class MinCostToMakeIdenticalString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(solution(s1,s2,x,y));
    }
    public static int solution(String s1,String s2,int c1,int c2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=0;
                }else if(i==dp.length-1){
                    dp[i][j]=0;
                }else if(j==dp[0].length-1){
                    dp[i][j]=0;
                }else{
                    if(s1.charAt(i)==s2.charAt(j) ){
                        dp[i][j]=dp[i+1][j+1]+1; // diagonal + 1
                    }else{
                        dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]); // max of right and below element
                    }
                }
            }
        }
        int lcs = dp[0][0];
        int s1r=s1.length()-lcs;
        int s2r=s2.length()-lcs;
        int cost=(s1r*c1)+(c2*s2r);
        return cost;
    }
}
