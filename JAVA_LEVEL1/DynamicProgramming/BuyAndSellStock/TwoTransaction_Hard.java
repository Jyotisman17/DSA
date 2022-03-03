package PEP.JAVA_LEVEL1.DynamicProgramming.BuyAndSellStock;

import java.util.Scanner;

public class TwoTransaction_Hard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();

        int mpist = 0; // max  profit if sold today
        int leastsf = arr[0]; // least so far
        int[] dpl = new int[arr.length]; // dp max profit if sold upto today

        for (int i = 1; i < arr.length; i++) {  //loop to fill dpleft array
            if(leastsf>arr[i])leastsf=arr[i];
            mpist = arr[i]-leastsf;
            if(mpist>dpl[i-1])dpl[i]=mpist;
            else dpl[i]=dpl[i-1];
        }

        int mpibt = 0; // maxm profit if bought today
        int maxat = arr[arr.length-1]; // maxm profit after today
        int[] dpr = new int[arr.length];

        for(int i=arr.length-2;i>=0;i--){ // loop to fill dpr array
            if(arr[i]>maxat)maxat=arr[i];
            mpibt = maxat-arr[i];

            if(mpibt > dpr[i+1]) dpr[i]=mpibt;
            else dpr[i]=dpr[i+1];
        }

        int op = 0; // overall profit

        for(int i=0;i<arr.length;i++){
            if(dpl[i]+dpr[i]>op)op=dpl[i]+dpr[i];
        }

        System.out.println(op); // printing our overall profit






    }
}
