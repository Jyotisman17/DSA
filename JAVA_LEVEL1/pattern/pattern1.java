package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern1 {
    public static void main(String[] args) {
        //*
        //* *
        //* * *               where 3 is given input

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}
