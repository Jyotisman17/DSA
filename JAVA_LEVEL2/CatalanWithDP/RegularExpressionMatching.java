package PEP.JAVA_LEVEL2.CatalanWithDP;
// * can replace any number of times of his previous character , including 0 times
// . can replace any character but only one time

import java.util.Scanner;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(solution(s1,s2));
    }
    // s : String
    // p : Pattern
    public static boolean solution(String s,String p){
        boolean[][] dp = new boolean[p.length()+1][s.length()+1]; // x: axis -> Pattern , y:axis -> String
        for(int i=0;i<dp.length;i++){ // i is for pattern
            for(int j=0;j<dp[0].length;j++){ //j is for string
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    char pc = p.charAt(i-1);
                    if(pc=='*'){
                        dp[i][j]=dp[i-2][j];
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    char pc = p.charAt(i-1);
                    char sc = s.charAt(j-1);

                    if(pc=='*'){
                        dp[i][j]=dp[i-2][j];
                        char pscl = p.charAt(i-2); // pattern's second last character
                        if(pscl=='.' || pscl==sc){
                            dp[i][j]|=dp[i][j-1];
                        }
                    }else if(pc=='.'){
                        dp[i][j]=dp[i-1][j-1]; // consider to be equal with the last character , so check the upper left place
                    }else if(pc==sc){
                        dp[i][j]=dp[i-1][j-1]; // same as stated above
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];

    }
}
