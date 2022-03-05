package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PrintAllMinCostPath {
    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        //write your code here

        int[][]  dp = new int[n][m]; // dp matrix
        for(int i=dp.length-1;i>=0;i--){ // filling the dp matrix
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i==dp.length-1){
                    dp[i][j]=arr[i][j]+dp[i][j+1]; // will move horizontally right
                }else if(j==dp[0].length-1){
                    dp[i][j]=arr[i][j]+dp[i+1][j]; // will move vertically downward
                }else{
                    dp[i][j]=arr[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        System.out.println(dp[0][0]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("",0,0));
        while(!queue.isEmpty()){
            Pair rem = queue.removeFirst();
            if(rem.i==dp.length-1 && rem.j == dp[0].length-1){ // reached end by entering to last cell
                System.out.println(rem.psf);
            }else if(rem.i==dp.length - 1){
                queue.add(new Pair(rem.psf+"H",rem.i,rem.j+1));
            }else if(rem.j==dp[0].length - 1){
                queue.add(new Pair(rem.psf+"V",rem.i+1,rem.j));
            }else{
                if(dp[rem.i][rem.j+1] < dp[rem.i+1][rem.j]){ // will move horizontal right
                    queue.add(new Pair(rem.psf+"H",rem.i,rem.j+1));
                }else if(dp[rem.i][rem.j+1] > dp[rem.i+1][rem.j]){ // will move vertical down
                    queue.add(new Pair(rem.psf+"V",rem.i+1,rem.j));
                }else{
                    queue.add(new Pair(rem.psf+"V",rem.i+1,rem.j));
                    queue.add(new Pair(rem.psf+"H",rem.i,rem.j+1));
                }
            }
        }






    }
}
