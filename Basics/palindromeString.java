package PEP.Basics;

import java.util.Scanner;

public class palindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String to check for whether its palindrome or not : ");
        String string = sc.next();
        String rev_string = reverse(string);
        if(string.equals(rev_string)) System.out.println("Palindrome String");
        else System.out.println("Not a Palindrome String");
    }

    private static String reverse(String string) {
        String revString = "";
        int len=string.length()-1;
        while(len>=0) revString+=string.charAt(len--);
        return  revString;
    }
}
