package PEP.JAVA_LEVEL1.DynamicProgramming.BuyAndSellStock;

import java.util.Scanner;

public class InfiniteTransaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<prices.length;i++)prices[i]=sc.nextInt();
        int bd = 0; // buying date
        int sd = 0; // selling date
        int profit = 0; // profit till date

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] >=prices[i-1]){
                sd++;
            }else{
                profit+=prices[sd]-prices[bd];
                bd=sd=i;
            }
        }
        profit+=prices[sd]-prices[bd];
        System.out.println(profit);
    }
}
