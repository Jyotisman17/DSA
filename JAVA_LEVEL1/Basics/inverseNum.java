package PEP.JAVA_LEVEL1.Basics;

import java.util.Scanner;

public class inverseNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int op=1,inverse=0;
        while(n!=0){
            int od=n%10;
            int id=op;
            int ip=od;
            inverse=inverse+id*(int) Math.pow(10,ip-1);
            n/=10;
            op++;
        }
        System.out.println(inverse);
    }
}
