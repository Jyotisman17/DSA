package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class SumOfBitDifferenceOfAllPairs {

    public static long solution(int[] arr){
        long res = 0;

        for(int i=0;i<32;i++){
            long counton=0;
            for(int val:arr){
                if((val & (1<<i))!=0){
                    counton++;
                }
            }
            long countoff = arr.length-counton;
            long diff = countoff * counton * 2;
            res+=diff;


        }
        return res;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
