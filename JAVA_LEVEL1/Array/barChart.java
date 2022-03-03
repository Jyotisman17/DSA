package PEP.JAVA_LEVEL1.Array;

import java.util.Scanner;

public class barChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int max=arr[0];
        for(int i:arr) if (i > max) max = i;
        for(int top=max;top>=1;top--) {
            for (int i = 0; i < n; i++) {
                if (top <= arr[i]) System.out.print("*\t");
                else System.out.print("\t");
            }
            System.out.println();
        }
    }
}
