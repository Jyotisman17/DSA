package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayWiithSumDivisibleByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(arr,k));
    }
    public static int solution(int[] arr,int k){
        int ans = 0;
        int sum = 0;
        int rem = 0;
        HashMap<Integer,Integer> map = new HashMap<>(); // remainder vs index
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            rem = sum%k;
            if(rem<0)rem+=k; // to normalize the negative remainder
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                int len = i - idx;
                if(len>ans) ans = len ;
            }else{
                map.put(rem,i);
            }
        }
        return ans;
    }
}
