package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class Triplets_1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        solutions(arr);
    }
    public static void solutions(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            for(int k=i+1;k<arr.length;k++){
                val=val^arr[k];
                if(val==0){
                    count+=(k-i);
                }
            }
        }
        System.out.println(count);
    }
}
