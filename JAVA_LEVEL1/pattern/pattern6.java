package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern6 {
    public static void main(String[] args) {/*
        *	*	*	*		*	*	*	*
        *	*	*				*	*	*
        *	*						*	*
        *								*
        *	*						*	*
        *	*	*				*	*	*
        *	*	*	*		*	*	*	*       */ //HERE INPUT IS GIVEN AS 7

        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int st=(num/2)+1;
        int sp=1;
        for(int i=1;i<=num;i++){
            for(int j=0;j<st;j++)
                System.out.print("*\t");
            for(int j=0;j<sp;j++)
                System.out.print("\t");
            for(int j=0;j<st;j++)
                System.out.print("*\t");
            System.out.println();
            if(i<=num/2){
                sp+=2;
                st--;
            }
            else{
                sp-=2;
                st++;
            }
        }
    }
}
