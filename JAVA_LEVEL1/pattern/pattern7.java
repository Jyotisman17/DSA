package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern7 {
    public static void main(String[] args) {/*
        *
            *
                *
                    *
                        *             */             // here the input is given 5

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sp=0;
        for(int i=1;i<=num;i++){
            for(int j=1;j<=sp;j++)
                System.out.print("\t");
            System.out.print("*\t");
            System.out.println();
            sp++;
        }
    }
}
