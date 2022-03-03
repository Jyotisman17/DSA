package PEP.Basics;

import java.util.Scanner;

public class findFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find its factorial : ");
        int n=sc.nextInt();
        long res = findFact(n);
        System.out.println("Factorial : "+res);
    }

    private static long findFact(int n) {
        if(n==0 | n==1)return 1;
        return n*findFact(n-1);
    }
}
