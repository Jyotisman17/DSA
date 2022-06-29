package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CountOfEquivalentSubArrays {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt(); // taking input for the array
        int k = countDistinct(arr); // No of distinct element in the array
        int i=-1,j=-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(true){
            boolean f1 = false , f2 = false;
            while(i<arr.length-1){
                f1=true;
                i++;
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                if(map.size()==k){
                    ans+=arr.length-i;
                    break;
                }
            }
            while(j<i){
                f2=true;
                j++;
                if(map.get(arr[j])==1)map.remove(arr[j]);
                else map.put(arr[j],map.get(arr[j])-1); // reducing the frequency of element
                if(map.size()==k)ans+=arr.length-i;
                else break;
            }
            if(!f1 && !f2)break; // break if the control doesnot enter both the loop

        }
        System.out.println(ans);
    }
    public static int countDistinct(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int a:arr)set.add(a);
        return set.size();
    }
}
