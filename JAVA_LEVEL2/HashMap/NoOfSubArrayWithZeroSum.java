package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class NoOfSubArrayWithZeroSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));

    }

    public static int solution(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int i=-1;
        int sum = 0;
        map.put(0,1);
        while(i<arr.length-1){
            i++;
            sum+=arr[i];
            if(map.containsKey(sum)){
                count+=map.get(sum);
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }


        return count;
    }
}
