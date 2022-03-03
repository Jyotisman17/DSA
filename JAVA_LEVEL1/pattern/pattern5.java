package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern5 {
    public static void main(String[] args) {

        //	    *
        //	 *	*  *
        //*  *	*  *  *
        //	 *	*  *
        //		*	     where 5 is the input value


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n/2;
        int st = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++)
                System.out.print("\t");
            for(int k=1;k<=st;k++)
                System.out.print("*\t");
            System.out.println();
            if(i<=n/2){
                sp--;
                st+=2;
            }else{
                sp++;
                st-=2;
            }

        }
    }
}
