package PEP.Basics;

import java.util.Scanner;

public class countEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to count odd even digits : ");
        int num = sc.nextInt();
        int evenCount=0,oddCount=0;
        while(num!=0){
            int temp=num%10;
            if(temp%2==0)evenCount++;
            else oddCount++;
            num/=10;
        }
        System.out.println("Even count = "+evenCount);
        System.out.println("Odd count = "+oddCount);

    }
}
