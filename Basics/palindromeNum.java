package PEP.Basics;

import java.util.Scanner;

public class palindromeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check for whether its palindrome or not ");
        int n = sc.nextInt();
        //Using reverse number approach
//        int revNum = reverse(n);
//        if (n == revNum) System.out.println("Palindrome");
//        else System.out.println("Not a Palindrome");

        //using two pointer approach
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        int start=0,end=stringBuilder.length();
        boolean flag=true;
        while(start<end){
            if(stringBuilder.charAt(start)!=stringBuilder.charAt(end-1)){
                System.out.println("Not a Palindrome");
                flag = false;
                break;
            }
            start++;
            end--;
        }
        if(flag) System.out.println("Palindrome");

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
