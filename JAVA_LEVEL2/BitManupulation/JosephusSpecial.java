package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class JosephusSpecial { // will be killed alternate peoples
    public static int powerof2(int n){
        int i=1;
        while(i*2<n){
            i*=2;
        }
        return i;
    }
    public static int solution(int n){
        //write your code here
        int hp2 = powerof2(n);
        return 0;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}
