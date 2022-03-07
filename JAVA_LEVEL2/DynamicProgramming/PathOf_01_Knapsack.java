package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PathOf_01_Knapsack {

    public static class Pair{
        int i;
        int j;
        String psf;

        Pair(int i,int j,String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for(int i=0;i<n;i++){
            values[i]=Integer.parseInt(str1.split(" ")[i]);
        }

        int []wts = new int[n];
        String str2 = br.readLine();
        for(int i=0;i<n;i++){
            wts[i]=Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        // From here onwards code is written by user

        int[][] dp = new int[values.length+1][cap+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=wts[i-1]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j- wts[i-1]]+values[i-1]);
                }
            }
        }
        int ans = dp[dp.length-1][dp[0].length-1]; // right bottom corner is our answer
        System.out.println(ans);

        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(values.length,cap,""));

        while(!que.isEmpty()){
            Pair rem = que.removeFirst();

            if(rem.i==0 || rem.j==0){ // if reaches first row or first column
                System.out.println(rem.psf);
            }else{
                int exc = dp[rem.i-1][rem.j]; // value when the item is not included

                if(rem.j>=wts[rem.i-1]) {
                    int inc = dp[rem.i - 1][rem.j - wts[rem.i - 1]] + values[rem.i - 1];

                    if (dp[rem.i][rem.j] == inc) {
                        que.add(new Pair(rem.i - 1, rem.j - wts[rem.i - 1], (rem.i - 1) + " " + rem.psf));
                    }
                }
                if(dp[rem.i][rem.j]==exc){
                    que.add(new Pair(rem.i-1,rem.j,rem.psf));
                }
            }


        }

    }
}
