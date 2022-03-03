package PEP.Basics;

import java.util.Scanner;

public class reverseUntilPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int palindromeAns = n;
        while(!isPalindrome(n)){
            int temp = reverse(n);
            n=n+temp;
            palindromeAns=n;
        }
        System.out.println(palindromeAns);
    }
    public static boolean isPalindrome(int n){
        if(reverse(n)==n)return true;
        return false;
    }
    private static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
