package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class FlipBitsToConvert {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        //write your code here
        int c = a ^ b;
        int countBits = count(c);
        System.out.println(countBits);

    }
    public static int count(int c){
        int count = 0;
        while(c!=0){
            int rsb = c & -c;
            c-=rsb;
            count++;
        }
        return count;
    }
}
