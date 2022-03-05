package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumXORPairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr){
        Arrays.sort(arr);
        ArrayList<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int xor = arr[i]^arr[i+1];
            if(xor<min) {
                min = xor;
                res = new ArrayList<>();
                res.add(arr[i]+", "+arr[i+1]);
            }else if(xor==min){
                res.add(arr[i]+", "+arr[i+1]);
            }

        }
        for(String val:res) System.out.println(val);
    }
}
