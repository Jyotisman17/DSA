package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class CountPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[][] dp = new int[str.length()][str.length()];

        for(int g=0;g<str.length();g++){
            for(int i=0,j=g;j<str.length();i++,j++) {
                if (g == 0) { // if gap is 0
                    dp[i][j]=1;
                } else if (g == 1) {
                    dp[i][j]=str.charAt(i)==str.charAt(j)?3:2;
                } else {
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=dp[i][j-1]+dp[i+1][j]-1; // when extremes are equal
                    }else{
                        dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1]; // when extremes are not equal
                    }
                }
            }
        }
        System.out.println(dp[0][str.length()-1]);
    }
}
