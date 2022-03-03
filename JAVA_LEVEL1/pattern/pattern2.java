package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern2 {
    public static void main(String[] args) {
        //* * *
        //* *
        //*          where 3 is given as input

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 5; i >= 1; i--) {
            for (int j = i; j >= 1; j--)
                System.out.print("*\t");
            System.out.println();
        }
    }
}
