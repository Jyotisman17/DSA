package PEP.JAVA_LEVEL1.DynamicProgramming;

import java.util.Scanner;

public class countBinStr {
    public static int getval(int n ){
        if(n==0||n==1)return n;
        return getval(n-1)+getval(n-2);
    }
    public static void main(String[] args) {
        // using a self created approach
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // here we will fibonacci approach



        int val1 = getval(n);
        int val2 = getval(n+1);
        System.out.println(val1+val2);







        //using variables only
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int oczeros = 1;
//        int ocones = 1;
//
//        for(int i=2;i<=n;i++){
//            int nczeros = ocones;
//            int ncones = ocones + oczeros;
//
//            oczeros = nczeros;
//            ocones = ncones;
//        }
//        System.out.println(ocones+oczeros);





        //using an array to solve this problem
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] dp0 = new int[n+1];
//        int[] dp1 = new int[n+1];
//
//        dp0[1]=1;
//        dp1[1]=1;
//
//        for(int i=2;i<=n;i++){
//            dp1[i]=dp1[i-1]+dp0[i-1];
//            dp0[i]=dp1[i-1];
//        }
//
//        System.out.println(dp1[n]+dp0[n]);




    }
}
