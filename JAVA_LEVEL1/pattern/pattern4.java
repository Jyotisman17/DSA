package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern4 {
    public static void main(String[] args) {

        //* * *
        //  * *
        //    *   where 3 is the inputted value

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = 0, st = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sp; j++)
                System.out.print("\t");
            for (int k = 1; k <= st; k++)
                System.out.print("*\t");
            sp++;
            st--;
            System.out.println();
        }
    }
}
