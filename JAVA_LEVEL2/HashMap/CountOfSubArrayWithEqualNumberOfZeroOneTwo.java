package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class CountOfSubArrayWithEqualNumberOfZeroOneTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr){
        int ans = 0;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        String key = (c1-c0)+"#"+(c2-c1);
        HashMap<String,Integer> map = new HashMap<>();
        map.put(key,1);
        for(int val:arr){
            if(val==0){
                c0++;
            }else if(val==1){
                c1++;
            }else{
                c2++;
            }

            key=(c1-c0)+"#"+(c2-c1);
            if(map.containsKey(key)){
                ans+=map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        return ans;
    }
}
