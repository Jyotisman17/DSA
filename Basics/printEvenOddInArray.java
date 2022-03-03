package PEP.Basics;

import java.util.Scanner;

public class printEvenOddInArray {
    public static void main(String[] args) {
        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 elements for the array : ");
        for (int i = 0; i < 10; i++) arr[i] = sc.nextInt();
        System.out.println("\nEven numbers in this array are : ");
        for (int values : arr) if (values % 2 == 0) System.out.print(values + " ");
        System.out.println("\nOdd numbers in this array are : ");
        for (int values : arr) if (values % 2 != 0) System.out.print(values + " ");
    }
}
