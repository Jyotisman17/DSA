package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = 0;
        boolean[][] dp = new boolean[str.length()][str.length()];
        for(int g=0;g<str.length();g++){


            for(int i=0,j=g;j<str.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    dp[i][j]=str.charAt(i)==str.charAt(j);
                }else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j])len=g+1;
            }
        }
        System.out.println(len);
    }
}
