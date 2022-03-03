package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MaxmNonOverlappingBridges  {

    public static class Bridge implements Comparable<Bridge>{
        int n;
        int s;
        Bridge(int n,int s){
            this.n = n;
            this.s = s;
        }
        public int compareTo(Bridge o){
            if(this.n!=o.n)
                return this.n - o.n;
            else
                return this.s - o.s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Bridge[] bdgs = new Bridge[n];
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int north = Integer.parseInt(parts[0]);
            int south = Integer.parseInt(parts[1]);
            bdgs[i]=new Bridge(north,south);
        }
        Arrays.sort(bdgs); // will sort on the basis of north values

        int[] dp = new int[n];
        int omax = 0;
        for(int i=0;i<dp.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(bdgs[j].s <=bdgs[i].s){
                    if(dp[j]>max)max=dp[j];
                }
            }
            dp[i]=max+1;
            if(dp[i]>omax)omax=dp[i];
        }

        System.out.println(omax);
    }
}
