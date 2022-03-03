package PEP.JAVA_LEVEL1.DynamicProgramming.BuyAndSellStock;

import java.util.Scanner;

public class OneTransaction {
    // here we will go on testing every day as selling day and will be calculating the profit and go on comparing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];
        for(int i=0;i<n;i++)prices[i]=sc.nextInt();

        int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today

        for(int i = 0;i<prices.length;i++){
            if(prices[i]<lsf){
                lsf = prices[i];
            }
            pist = prices[i]-lsf;
            if(pist>op)op=pist;
        }
        System.out.println(op); // overall maximum profit
    }
}
