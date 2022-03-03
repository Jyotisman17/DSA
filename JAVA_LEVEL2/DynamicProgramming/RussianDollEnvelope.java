package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class RussianDollEnvelope {
    public static class Envelope implements Comparable<Envelope>{

        int w;
        int h;

        Envelope(int w,int h) {
            this.w = w;
            this.h = h;
        }
        @Override
        public int compareTo(Envelope o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Envelope[] envlps = new Envelope[n];
        for(int i=0;i<envlps.length;i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int w = Integer.parseInt(parts[0]);
            int h = Integer.parseInt(parts[1]);
            envlps[i]=new Envelope(w,h);
        }
        Arrays.sort(envlps);

        int[] dp = new int[n];
        int omax = 0; // overall max
        for(int i=0;i<dp.length;i++){
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(envlps[j].h < envlps[i].h && envlps[j].w < envlps[i].w){
                    if(dp[j]>max)max=dp[j];
                }
            }
            dp[i]=max+1;
            if(dp[i]>omax)omax=dp[i];
        }

        System.out.println(omax);

    }
}
