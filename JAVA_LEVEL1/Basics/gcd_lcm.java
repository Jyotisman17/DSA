package PEP.JAVA_LEVEL1.Basics;

import java.util.Scanner;

public class gcd_lcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt(); // first number
        int n2=sc.nextInt();  // second number
        int mul=n1*n2,gcd=1;
        while(n1%n2!=0){
            gcd=n1%n2;
            n1=n2;
            n2=gcd;
        }
        int lcm=mul/gcd;
        System.out.println(gcd+"\n"+lcm);

    }
}
