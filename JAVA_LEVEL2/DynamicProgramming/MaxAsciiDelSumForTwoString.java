package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class MaxAsciiDelSumForTwoString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solution(s1,s2));
    }
    public static int solution(String s1,String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    //when i and j both are in extreme
                    dp[i][j]=0;
                }
                else if(i==dp.length-1){
                    // last row
                    dp[i][j]=(int)s2.charAt(j)+dp[i][j+1];
                }else if(j==dp[0].length-1){
                    // last column
                    dp[i][j]=(int)s1.charAt(i)+dp[i+1][j];
                }else{
                    if(s1.charAt(i)==s2.charAt(j)){
                        dp[i][j]=dp[i+1][j+1];//taking the diagonal right down value
                    }else{
                        dp[i][j]=Math.min(s1.charAt(i)+dp[i+1][j],s2.charAt(j)+dp[i][j+1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
