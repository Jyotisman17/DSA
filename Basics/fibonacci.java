package PEP.Basics;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range of fibonacci series you want to print ");
        int range = sc.nextInt();

        //using iterative method
//        int n1=0,n2=1;
//        System.out.print(n1+" "+n2+" ");
//        int sum=0;
//        for(int i=2;i<range;i++){
//            sum=n1+n2;
//            System.out.print(sum+" ");
//            n1=n2;
//            n2=sum;
//        }

        //using recursion method
        for(int i=0;i<range;i++){
            System.out.print(fibo(i)+" ");
        }
    }

    private static int fibo(int i) {
        if(i==0 || i==1)return i;
        return fibo(i-1)+fibo(i-2);
    }

}
