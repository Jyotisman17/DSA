package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern20 {
    public static void main(String[] args) {
        /*
         *				*
         *				*
         *		*		*
         *	*		*	*
         *				*         here the input given is 5
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j==1 || j==n)
                    System.out.print("*\t");
                else if(i>n/2 && (i==j || i+j==n+1))
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            }
            System.out.println();
        }
    }
}
