package PEP.Basics;

import java.util.Scanner;

public class largestOf3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers : ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        //using algorithm
//        if(a>b)
//            if(a>c) System.out.println(a+" is largest");
//            else System.out.println(c+" is largest");
//        else
//            if(b>c) System.out.println(b+" is largest");
//            else System.out.println(c+" is largest");

        //using Ternary operator
        int largest=c>(a>b?a:b)?c:(a>b?a:b);
        System.out.println("Largest Number is "+largest);

    }
}
