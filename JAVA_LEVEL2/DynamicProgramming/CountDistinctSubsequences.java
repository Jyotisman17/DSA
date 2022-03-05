package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class CountDistinctSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        long[] dp = new long[string.length()+1];
        dp[0]=1;

        HashMap<Character,Integer> lo = new HashMap<>();
        for(int i=1;i<dp.length;i++){
            dp[i]=2*dp[i-1];
            char ch = string.charAt(i-1);
            if(lo.containsKey(ch)){
                int j = lo.get(ch);
                dp[i]-=dp[j-1];  // we are subtracting the previous of last occurance
            }else{
                lo.put(ch,i);
            }
        }
        System.out.println(dp[string.length()]-1);  // subtracting 1 to remove the first empty subsequence
    }
}
