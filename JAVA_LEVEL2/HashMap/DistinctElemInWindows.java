package PEP.JAVA_LEVEL2.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DistinctElemInWindows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int k = sc.nextInt();
        ArrayList<Integer> ans = solution(arr,k);
        for(int a:ans) System.out.println(a+" ");
    }

    public static ArrayList<Integer> solution(int[] arr,int k){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        while(i<=k-2){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            i++;
        }
        i--;
        int j=-1;
        while(i<arr.length-1){
            i++;
            map.put(arr[i],map.getOrDefault(arr[i],0)+1); // acquire kth value
            list.add(map.size()); // work
            j++;
            int freq = map.get(arr[j]);
            //release
            if(freq==1){
                map.remove(arr[j]);
            }else{
                map.put(arr[j],freq-1);
            }
        }

        return list;
    }
}
