package PEP.JAVA_LEVEL1.DynamicProgramming.BuyAndSellStock;

import java.util.Scanner;

public class WithTransactionFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();

        int fee = sc.nextInt();
        int obsp = -arr[0];  // old Buy state profit
        int ossp = 0; // old sold state profit
        for(int i=1;i<arr.length;i++){
            int nbsp = 0; // new buy state profit
            int nssp = 0; // new sold state profit

            if(ossp-arr[i] > obsp)nbsp=ossp-arr[i];
            else nbsp=obsp;

            if(obsp+arr[i]-fee > ossp)nssp=obsp+arr[i]-fee;
            else nssp = ossp;

            obsp = nbsp;
            ossp = nssp;
        }
        System.out.println(ossp);
    }
}
