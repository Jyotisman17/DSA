package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class CopySetOfBitsInRange {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();

        //write your code here
        int range = right - left + 1;
        int mask=1;
        mask = ((1<<range)-1)<<left-1;

        mask = mask & a;

        b = b|mask;
        System.out.println(b);
    }
}
