package PEP.JAVA_LEVEL1.pattern;

import java.util.Scanner;

public class pattern14 {
    public static void main(String[] args) {

        //Multiplication table
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(n+" * "+i+" = "+(n*i));
        }
    }
}
