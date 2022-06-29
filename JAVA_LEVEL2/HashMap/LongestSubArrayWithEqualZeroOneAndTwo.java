package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayWithEqualZeroOneAndTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr){
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        int countz = 0;
        int counto = 0;
        int countt = 0;
        int delta10 = counto-countz;
        int delta21 = countt - counto;
        String key = delta21+"#"+delta10;
        map.put(key,-1); // by default key and value which is for the index -1
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                countz++;
            }else if(arr[i]==1){
                counto++;
            }else{
                countt++;
            }
            delta10 = counto-countz;
            delta21 = countt - counto;
            key = delta21+"#"+delta10;
            if(map.containsKey(key)){
                int idx = map.get(key);
                int len = i - idx;
                if(len>ans)ans=len;
            }else{
                map.put(key,i);
            }
        }


        return ans;
    }
}
