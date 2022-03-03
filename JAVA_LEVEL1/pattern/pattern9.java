package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) { /*
            *				*
                *		*
                    *
                *		*
            *				*               here the input is 5   */

        //approach by brute force
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int spSide=0,spMiddle=n-2;
//        for(int i=1;i<=n;i++) {
//            for (int j = 1; j <= spSide; j++)
//                System.out.print("\t");
//            System.out.print("*\t");
//            for (int j = 1; j <= spMiddle ; j++)
//                System.out.print("\t");
//            if (i != (n / 2) + 1) System.out.print("*\t");
//            for (int j = 1; j <= spSide; j++)
//                System.out.print("\t");
//            System.out.println();
//            if (i <= n / 2) {
//                spMiddle -= 2;
//                spSide++;
//            }
//            else{
//                spMiddle+=2;
//                spSide--;
//            }
//        }



        //approach by trick by playing with indexes

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a num ");
        int num=sc.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (i == j || i + j == num + 1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }


    }
}
