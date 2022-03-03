package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class KernighansAlgo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        while(n!=0){
            int rbsm = n & -n;
            n-=rbsm;
            count++;
        }
        System.out.println(count);
    }
}
