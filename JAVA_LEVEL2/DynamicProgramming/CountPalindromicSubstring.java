package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class CountPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<dp.length;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }
                else if(g==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j); // will check and put the value in the dp array
                }
                else{
                    boolean firstCheck = s.charAt(i)==s.charAt(j);
                    boolean secondCheck = dp[i+1][j-1]; // middle value
                    if(firstCheck && secondCheck){
                        dp[i][j]=true;
                    }
                    else dp[i][j] = false;
                }
                if(dp[i][j])count++;
            }

        }
        System.out.println(count);
    }
}
