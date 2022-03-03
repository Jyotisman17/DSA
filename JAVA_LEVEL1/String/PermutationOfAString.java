package PEP.JAVA_LEVEL1.String;

import java.util.Scanner;

public class PermutationOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solution(str);
    }
    public static void solution(String str){
        int n = str.length();
        int f = factorial(n);
        for(int i=0;i<f;i++){
            StringBuilder sb = new StringBuilder(str);
            int temp=i;
            for(int div = n;div>=1;div--){
                int q = temp/div;
                int r = temp%div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println();
        }
    }
    public static int factorial(int n){
       if(n==0)return 1;
       return n*factorial(n-1);
    }
}
