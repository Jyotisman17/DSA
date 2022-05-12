package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class CheckIfArrayCanHavePairDivisibleByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int k = sc.nextInt();
        solution(arr,k);
    }
    public static void solution(int[] arr , int k){
        HashMap<Integer,Integer> rfmap = new HashMap<>();
        for(int val:arr){
            int rem = val%k;
            int of = rfmap.getOrDefault(rem,0);
            rfmap.put(rem,of+1);
        }
        // condition required
        // x and k-x should have equal freq AND 0 and k/2 should have even number of freq
        for(int val:arr){
            int rem = val%k;
            if(rem==0){
                int fq = rfmap.get(rem);
                if(fq%2!=0){
                    System.out.println(false);
                    return;
                }
            }else if(2*rem==k){ // why not k/2 -->
                int fq = rfmap.get(rem);
                if(fq%2!=0){
                    System.out.println(false);
                    return;
                }
            }else{
                int fq = rfmap.get(rem);
                int ofq = rfmap.getOrDefault(k-rem,0);
                if(fq!=ofq){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}
