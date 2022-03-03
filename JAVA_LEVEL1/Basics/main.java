package PEP.JAVA_LEVEL1.Basics;

import java.util.*;

public class main{

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int n1=0,n2=1,sum=0;
        if(n==1)System.out.println(n1);
        else if(n==2)System.out.println(n1+"\n"+n2);
        else{
            for(int i=3;i<=n;i++){
                sum=n1+n2;
                System.out.println(sum);
                n1=n2;
                n2=sum;
            }
        }
    }
}