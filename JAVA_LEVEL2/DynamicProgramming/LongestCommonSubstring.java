package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubstring {
    public static int solution(String s1, String s2){
        //write your code here
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else{
                    char s1char = s1.charAt(i-1);
                    char s2char = s2.charAt(j-1);

                    if(s1char==s2char){
                        dp[i][j]=dp[i-1][j-1]+1;
                        if(dp[i][j]>max)max=dp[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1,s2));
    }
}
