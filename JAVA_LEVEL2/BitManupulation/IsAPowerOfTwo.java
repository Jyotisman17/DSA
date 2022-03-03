package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class IsAPowerOfTwo { // here we will check whether its a power of two or not
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //write your code here
        // if we will do and operator between n and n- 1, and if it given 0 then its true otherwise false
        int m = n-1;
        if((n&m)==0) System.out.println(true);
        else System.out.println(false);
    }
}
