package PEP.JAVA_LEVEL2.Backtracking;

import java.util.Scanner;

public class PrintLexicographically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Write your code here
        for(int i=1;i<=9;i++){
            dfs(i,n);
        }
    }
    public static void dfs(int i,int n){
        if(i>n)return;

        System.out.println(i);
        for(int j=0;j<10;j++){
            dfs(i*10+j,n);
        }
    }
}
