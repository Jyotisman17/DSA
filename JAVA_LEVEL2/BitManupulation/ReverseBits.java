package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class ReverseBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        int rev = 0;
        int j=0;
        for (int i = 31; i >= 0; i--) {
            int mask = (1 << i); // it will help us to check the bits
            if (flag) {
                if ((n & mask) == 0) { // bit is off
                    System.out.print(0);
                } else { // bit is on
                    System.out.print(1);
                    int smask = (1<<j);
                    rev|=smask;
                }
                j++;
            } else {
                if ((n & mask) == 0) { // bit is off
                    continue;
                } else { // bit is on
                    System.out.print(1);
                    flag = true;
                    int smask = (1<<j);
                    rev|=smask;
                    j++;
                }
            }
        }
        System.out.println("\n"+rev);
    }
}
