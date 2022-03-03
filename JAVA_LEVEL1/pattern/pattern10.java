package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern10 {
    public static void main(String[] args) { /*
    		*
        *		*
    *				*
        *		*
            *	           here the input given is 5                      */
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int osp=num/2,isp=-1;
        for(int i=1;i<=num;i++){
            for(int j=1;j<=osp;j++)
                System.out.print("\t");
            System.out.print("*\t");
            for(int j=1;j<=isp;j++)
                System.out.print("\t");
            if(i!=1 && i!=num)
                System.out.print("*\t");
            System.out.println();
            if(i<=num/2)
            {
               osp--;
               isp+=2;
            }
            else
            {
                osp++;
                isp-=2;
            }
        }

    }
}
