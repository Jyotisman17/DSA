package PEP.JAVA_LEVEL2.Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintPermutations {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());

        permutations(new int[nboxes],1,ritems);
    }

    public static void permutations(int[] boxes,int ci,int ti){

        if(ci>ti){
            for(int val:boxes){
                System.out.print(val);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i]=ci;
                permutations(boxes,ci+1,ti);
                boxes[i]=0;
            }
        }
    }


}
