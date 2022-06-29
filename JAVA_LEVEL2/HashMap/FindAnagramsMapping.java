package PEP.JAVA_LEVEL2.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++)arr1[i]=sc.nextInt();
        for(int i=0;i<n;i++)arr2[i]=sc.nextInt();
        int[] res = anagramMapping(arr1,arr2);
        for(int i=0;i<res.length;i++) System.out.println(res[i]+" ");
    }
    public static int[] anagramMapping(int[] arr1,int[] arr2){
        HashMap<Integer,Pair> map = new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                Pair p = map.get(arr2[i]);
                p.list.add(i);
            }else{
                map.put(arr2[i],new Pair(i));
            }
        }
        int[] ans = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            Pair p = map.get(arr1[i]);
            ans[i]=p.list.get(p.idx);
            p.idx++;
        }
        return ans;
    }
    public static class Pair{
        int idx;
        ArrayList<Integer> list=new ArrayList<>();
        Pair(int e){
            this.idx=0;
            list.add(e);
        }
    }
}
