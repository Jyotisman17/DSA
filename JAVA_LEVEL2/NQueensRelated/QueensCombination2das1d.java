package PEP.JAVA_LEVEL2.NQueensRelated;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueensCombination2das1d {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        if(qpsf==tq){
            for(int i=0;i<chess.length;i++){
                for(int j=0;j<chess.length;j++){
                    if(chess[i][j]==true)
                        System.out.print("q\t");
                    else
                        System.out.print("-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int cell=lcno+1;cell<chess.length*chess.length;cell++){
            int row = cell/chess.length;
            int col = cell%chess[0].length;

            chess[row][col]=true;
            queensCombinations(qpsf+1,tq,chess,cell);
            chess[row][col]=false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
