package PEP.JAVA_LEVEL1.DynamicProgramming.BuyAndSellStock;

import java.util.Scanner;

public class withCoolDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();

        int obsp = -arr[0] ; // old bought state profit
        int ossp = 0; // old sold state profit
        int ocsp = 0; // old cool state profit

        for(int i=1;i<arr.length;i++){
            int nbsp = 0; // new bought state profit
            int nssp = 0; // new sold state profit
            int ncsp = 0; // new cool state profit

            if(ocsp-arr[i]>obsp){
                nbsp = ocsp-arr[i];
            }else{
                nbsp=obsp;
            }

            if(obsp+arr[i] > ossp){
                nssp = obsp+arr[i];
            }else {
                nssp = ossp;
            }

            if(ossp>ocsp)ncsp = ossp;
            else ncsp = ocsp;

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
    }
}
