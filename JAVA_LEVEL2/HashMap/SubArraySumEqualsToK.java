package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class SubArraySumEqualsToK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int target = sc.nextInt();
        System.out.println(solution(arr,target));
    }
    public static int solution(int[] arr, int target){
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // we need to put this to get the direct sum
        int sum = 0; // prefix sum value
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
//            int rsum = sum-target; // remaining sum
            if(map.containsKey(sum-target))
                ans+=map.get(sum-target);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
