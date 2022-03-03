package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern17 {
    public static void main(String[] args) {
       /*
                    *
                    *	*
            *	*	*	*	*
                    *	*
                    *                      here 5 is inputted
		*/

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n/2 , st = 1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sp;j++)
                if(i==n/2+1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            for(int j=1;j<=st;j++)
                System.out.print("*\t");
            if(i<=n/2) st++;
            else st--;
            System.out.println();
        }
    }
}
