package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class RodCuttingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i]=sc.nextInt();
        }

        System.out.println(solution(prices));
    }

    public static int solution(int[] prices ){
        int[] np = new int[prices.length+1];
        for(int i=0;i<prices.length;i++){
            np[i+1]=prices[i]; // sliding each element to right side to bring 0 in 0th index
        }

        int[] dp = new int[np.length];
        dp[0]=0;
        dp[1]=np[1];
        for(int i=2;i<dp.length;i++){
            dp[i]=np[i];

            int li = 1;
            int ri = i-1;

            while(li<=ri){
                if(dp[li]+dp[ri] > dp[i]){
                    dp[i]=dp[li]+dp[ri];
                }
                li++;
                ri--;
            }
        }

        return dp[dp.length-1];


    }
}
