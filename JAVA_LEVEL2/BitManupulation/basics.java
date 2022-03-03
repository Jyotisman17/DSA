package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt(); // set ith bit on
        int j = sc.nextInt(); // set jth bit off
        int k = sc.nextInt(); // toggle its kth bit
        int m = sc.nextInt(); // check mth bit and print true for on and false for off

        int onmask=(1<<i);
        int offmask=~(1<<j);
        int toggleMask=(1<<k);
        int checkMask=(1<<m);

        System.out.println(onmask|n);
        System.out.println(n|offmask);
        System.out.println(n^toggleMask);
        System.out.println((n & checkMask) != 0); //         System.out.println((n&checkMask)==0?false:true);


        //
    }
}
