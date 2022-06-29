package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestContiguousArrayHavingEqualNoOfZeroAndOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr){
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum+=-1;
            }else if(arr[i]==1){
                sum+=1;
            }
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                int  len = i-idx;
                if(len>ans)ans=len;
            }else{
                map.put(sum,i);
            }
        }
        return ans;
    }
}
