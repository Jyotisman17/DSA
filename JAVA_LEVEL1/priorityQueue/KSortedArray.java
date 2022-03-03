package PEP.JAVA_LEVEL1.priorityQueue;

import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,2,1,4,6,7,5};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            pq.add(arr[i]);
            System.out.println(pq.remove());
        }
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}
