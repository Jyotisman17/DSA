package PEP.JAVA_LEVEL1.NumberSystem;

import java.util.Scanner;

public class anyBaseAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2){
        // write ur code here
        int result = 0;
        int c=0;
        int p=1;
        while(n1>0 || n2>0 || c>0)
        {
            int d1=n1%10;
            int d2=n2%10;
            n1/=10;
            n2/=10;

            int sum=d1+d2+c;
            c=sum/b;
            sum%=b;
            result+=sum*p;
            p=p*10;

        }
        return  result;
    }
}
