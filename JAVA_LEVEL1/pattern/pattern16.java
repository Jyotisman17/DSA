package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern16 {
    public static void main(String[] args) {
        /*
            1												1
            1	2										2	1
            1	2	3								3	2	1
            1	2	3	4						4	3	2	1
            1	2	3	4	5				5	4	3	2	1
            1	2	3	4	5	6		6	5	4	3	2	1
            1	2	3	4	5	6	7	6	5	4	3	2   1            here 7 is given as input
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = 2 * n - 3;
        int st = 1;
        for(int i=1;i<=n;i++)
        {
            int val = 1;
            for(int j=1;j<=st;j++)
                System.out.print((val++)+"\t");
            for(int j=1;j<=sp;j++)
                System.out.print("\t");
            if(i==n){
                st--;
                val--;
            }
            for(int j=1;j<=st;j++)
                System.out.print(--val+"\t");

            st++;
            sp-=2;
            System.out.println();


        }

    }
}
