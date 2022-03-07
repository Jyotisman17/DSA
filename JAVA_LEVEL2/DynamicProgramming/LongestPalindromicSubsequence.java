package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[][] dp = new int[str.length()][str.length()];
        for(int g=0;g<str.length();g++){
            for(int i=0,j=g;j<dp.length;i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    dp[i][j]= str.charAt(i)==str.charAt(j)?2:1;
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]+=dp[i+1][j-1]+2; // here if the start and end character are same
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]); // here we are comparing suffix and prefix , and maximum will be our answer
                    }
                }
            }
        }
        System.out.println(dp[0][dp.length-1]);   // top right corner will be contain our answer ultimately
    }
}
