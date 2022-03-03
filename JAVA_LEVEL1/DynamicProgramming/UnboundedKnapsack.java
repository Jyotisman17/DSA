package PEP.JAVA_LEVEL1.DynamicProgramming;

import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] vals = new int[n];
//        for(int i=0;i<vals.length;i++)
//            vals[i]=sc.nextInt();
//        int[] wts = new int[n];
//        for(int i=0;i<wts.length;i++)
//            wts[i]=sc.nextInt();
//
//        int cap = sc.nextInt();
//
//        int[] dp = new int[cap+1];
//        dp[0]=0;
//        for(int bagc = 1;bagc<=cap;bagc++){
//            int max = 0;
//            for(int i=0;i<n;i++){
//
//                if(wts[i]<=bagc){
//                    int rbagc = bagc-wts[i];
//                    int rbagv = dp[rbagc];
//                    int tbgb = rbagv+vals[i];
//
//                    if(tbgb>max)max=tbgb;
//                }
//            }
//            dp[bagc]=max;
//        }
//        System.out.println(dp[cap]);










        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] vals = new int[n];
        int[] wts = new int[n];

        for(int i=0;i<vals.length;i++)vals[i]=sc.nextInt();
        for(int i=0;i< wts.length;i++)wts[i]=sc.nextInt();

        int cap = sc.nextInt();

        int[] dp = new int[cap+1];
        dp[0]=0;
        for(int bagc=1;bagc<=cap;bagc++){
            int max = Integer.MIN_VALUE;
            for(int i=0;i< wts.length;i++){
                if(wts[i]<=bagc){
                    int rbagc = bagc-wts[i];
                    int rbagv = dp[rbagc];
                    int totalValue = rbagv+vals[i];

                    if(totalValue>max)max=totalValue;
                }
            }
            dp[bagc]=max;
        }
        System.out.println(dp[cap]);

    }
}
