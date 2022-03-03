package PEP.Basics;

import java.util.Scanner;

public class checkPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check for whether its prime or not ");
        int num = sc.nextInt();
        if(checkPrime(num)) System.out.println("Prime number ");
        else System.out.println("Not a prime number ");
    }
    protected static boolean checkPrime(int n){
        if(n==0 || n==1)return false;
        for(int i=2;i<n;i++) if(n%i==0)return false;
        return true;
    }
}
