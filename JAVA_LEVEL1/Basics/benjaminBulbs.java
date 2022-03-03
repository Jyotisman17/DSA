package PEP.JAVA_LEVEL1.Basics;

import java.util.Scanner;

public class benjaminBulbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=1;i*i<=num;i++) System.out.println((i*i));
    }
}
