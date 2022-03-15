package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class CountOfDistinctPalidromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static int solution(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int[] next = new int[str.length()]; // we will store the index of next occurance
        int[] prev = new int[str.length()]; // we will store the index of previously occured

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i); // character at ith position

            if(!map.containsKey(ch)){ // no previous occurance found
                prev[i]=-1;
            }else{
                prev[i]=map.get(ch); // getting the previous occurance from map
            }

            map.put(ch,i); // putting the current occurance in map
        } // working to fill prev arr
        map.clear();
        for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)){
                next[i]=-1;
            }else{
                next[i]=map.get(ch);
            }
            map.put(ch,i);
        } // working to fill next arr

        for(int g=0;g<str.length();g++){
            for(int i=0,j=g;j<str.length();i++,j++){
                if(g==0){
                    dp[i][j]=1; // for gap 1 , there will be one palindromic subsequence
                }else if(g==1){
                    dp[i][j]=2; // for gap 2 , there will be two palindromic subsequence
                }else {
                    char sc = str.charAt(i);
                    char ec = str.charAt(j);

                    if(sc!=ec){  // if starting character and ending character are not same
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    }else{ // if starting character and ending character are same
                        int nis = next[i];  // next index of ith index
                        int pie = prev[j];  // prev index of jth index

                        if(nis<pie){
                            dp[i][j] = 2*dp[i+1][j-1] - dp[nis+1][pie-1];
                        }else if(nis==pie){
                            dp[i][j] = 2*dp[i+1][j-1] + 1;
                        }else if(nis>pie){
                            dp[i][j] = 2*dp[i+1][j-1] + 2;
                        }  // checking any end point occurance

                    }
                }


            }
        }





        return dp[0][str.length()-1];

    }
}
