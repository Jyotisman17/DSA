package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class SevenNBy8 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //write your code here
        int eightN = (n<<3);
        System.out.println(eightN);
        eightN-=n;
        eightN=eightN>>3;
        System.out.println(eightN);

    }
}
