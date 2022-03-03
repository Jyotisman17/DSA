package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class AllRepeatingExceptTwo {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        //write your code here
        solution(arr);
    }
    public static void solution(int[] arr){
        int xXORy = 0;
        for(int val:arr){
            xXORy = xXORy ^ val;
        }

        int rsbm = xXORy & -xXORy;
        int zxor = 0;
        int nzxor = 0;
        for (int val : arr) {
            if((val & rsbm)==0){ // for xor of zero finding bit
                zxor=zxor^val;
            }
            else{ // for xor of non zero finding bit
                nzxor = nzxor ^ val;
            }
        }
        if(zxor<nzxor)
            System.out.println(zxor+" "+nzxor);
        else
            System.out.println(nzxor+" "+zxor);
    }
}
