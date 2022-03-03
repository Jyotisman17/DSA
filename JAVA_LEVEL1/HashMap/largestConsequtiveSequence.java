package PEP.JAVA_LEVEL1.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class largestConsequtiveSequence {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,Boolean> hmap = new HashMap<>();
        // setting false for all the value for the elements for the array
        for(int val:arr)
            hmap.put(val,true);

        for(int val:arr)
            if(hmap.containsKey(val-1))
                hmap.put(val,false);

        int ml=0;
        int mls=0;
        for(int val:arr){
            if(hmap.get(val)==true){
                int tl=1;
                int tsp=val;
                while(hmap.containsKey(tsp+tl)){
                    tl++;
                }
                if(tl>ml){
                    ml=tl;
                    mls=tsp;
                }
            }
        }

        System.out.println("Starting element of the maximum cosecutive sequence is : "+mls);
        System.out.println("Length is : "+ml);
    }
}
