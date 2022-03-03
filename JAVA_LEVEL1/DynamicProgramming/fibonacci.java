package PEP.JAVA_LEVEL1.DynamicProgramming;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
//        int res = getFibo(n);
        int res = FiboMemoized(n,new int[n+1]);
        System.out.println("Fibonacci series : "+res);
    }
    public static int getFibo(int n){
        if(n==0 || n==1)return n;
        return getFibo(n-1)+getFibo(n-2);
    }

    public static int FiboMemoized(int n,int[] qb){
        if(n==0||n==1)return n;
        if(qb[n]!=0)return qb[n];
        return qb[n]=FiboMemoized(n-1,qb)+FiboMemoized(n-2,qb);
    }
}
