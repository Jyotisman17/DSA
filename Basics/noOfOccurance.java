package PEP.Basics;

import java.util.Scanner;

public class noOfOccurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String string = sc.nextLine();
        System.out.println("Enter a chracter to find the no of occurances ");
        char key = sc.next().charAt(0);
        int totalLength = string.length();
        int lengthAfterRemoval = string.replace(Character.toString(key),"").length();
        System.out.println("No of occurance of "+key+" are : "+(totalLength-lengthAfterRemoval));
    }
}
