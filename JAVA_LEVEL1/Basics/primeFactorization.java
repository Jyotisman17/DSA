package PEP.JAVA_LEVEL1.Basics;

import java.util.Scanner;

public class primeFactorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=2;i*i<=num;i++){
            while(num%i==0){
                num/=i;
                System.out.print(i+" ");
            }
        }
        if(num!=1)
            System.out.print(num);
    }
}
