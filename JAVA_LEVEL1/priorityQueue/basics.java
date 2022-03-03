package PEP.JAVA_LEVEL1.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class basics {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // it will give more prior to the lowest value
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder()); // it will give more prior to the greatest value
        int[] ranks = {22,32,11,1,33,22,14,13,654};
        for(int val:ranks)pq.add(val);
        for(int val:ranks)pq1.add(val);
        while(pq.size()>0) {
            System.out.println(pq.peek());
            pq.remove();
        }
        while(pq1.size()>0){
            System.out.println(pq1.peek());
            pq1.remove();
        }


    }
}
