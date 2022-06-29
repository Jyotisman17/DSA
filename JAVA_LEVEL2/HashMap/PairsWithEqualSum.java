package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashSet;
import java.util.Scanner;

public class PairsWithEqualSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(solution(arr));
    }

    public static boolean solution(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                if(set.contains(sum))return true;
                else set.add(sum);
            }
        }
        return false;
    }
}
