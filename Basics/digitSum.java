package PEP.Basics;

import java.util.Scanner;

public class digitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to calculate the sum of digits ");
        int n = sc.nextInt();
        int sum = 0 ;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        System.out.println("Sum of the digits are "+sum);
    }
}
