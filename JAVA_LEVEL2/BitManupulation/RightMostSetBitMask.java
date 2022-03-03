package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class RightMostSetBitMask {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // here we will do n & 2s compliment of n which is equal to n & -n;
        int rsbm = n & -n;
        System.out.println(Integer.toBinaryString(rsbm));
    }
}
