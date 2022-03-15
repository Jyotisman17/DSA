package PEP.JAVA_LEVEL2.CatalanWithDP;

import java.util.Scanner;

public class WaysOfPolygon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }
    public static int solution(int n){
        n=n-2;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            int l=i-1;
            int r =0;
            while(l>=0){
                dp[i]+=dp[l]*dp[r];
                l--;
                r++;
            }
        }

        return(dp[n]);
    }
}
