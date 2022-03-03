package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern12 {
    public static void main(String[] args) {
        /*
        0
        1	1
        2	3	5
        8	13	21	34
        55	89	144	233	377	                here the input is 5
         */

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a=0,b=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) {
                System.out.print(a + "\t");
                int c = a + b;
                a = b;
                b = c;
            }
            System.out.println();
        }
    }
}
