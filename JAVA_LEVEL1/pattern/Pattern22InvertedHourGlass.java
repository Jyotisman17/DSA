package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class Pattern22InvertedHourGlass {
    public static void main(String[] args) {
        /*
         *	*	*	*	*	*	*	*	*
            *	*	*	*	*	*	*
                *	*	*	*	*
                    *	*	*
                        *
                    *		*
                *				*
             *						*
         *	*	*	*	*	*	*	*	*
         */  // here 9 is given as input

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp=0,st=n;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sp;j++)
                System.out.print("\t");
            for(int j=1;j<=st;j++)
                if(i<n && i>n/2 && j>1 && j<st)
                    System.out.print("\t");
                else
                    System.out.print("*\t");
            if(i<=n/2){
                st-=2;
                sp++;
            }
            else
            {
                st+=2;
                sp--;
            }
            System.out.println();

        }
    }
}
