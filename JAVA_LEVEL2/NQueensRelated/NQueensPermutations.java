package PEP.JAVA_LEVEL2.NQueensRelated;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueensPermutations {
    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        for(int i=row,j=col ; i>=0;i--){
            if(chess[i][j]>0)return false; // veritcally up
        }

        for(int i=row,j=col ; i<chess.length;i++){
            if(chess[i][j]>0)return false; // vertically down
        }

        for(int i=row,j=col;j<chess.length;j++){
            if(chess[i][j]>0)return false; // horizontally right
        }

        for(int i=row,j=col;j>=0;j--){
            if(chess[i][j]>0)return false; // horizontally left
        }

        for(int i=row,j=col;i>=0 && j>=0 ;j--,i--)
            if(chess[i][j]>0)return false; // left up diagonal

        for(int i=row,j=col;i>=0 && j<chess.length;i--,j++)
            if(chess[i][j]>0)return false; // right up diagonal

        for(int i=row,j=col;i<chess.length && j<chess.length;j++,i++){
            if(chess[i][j]>0)return false; // right down diagonal
        }

        for(int i=row,j=col;i<chess.length && j>=0 ;i++,j--){
            if(chess[i][j]>0)return false; // left down diagonal
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here

        if(qpsf==tq){
            for(int i=0;i<chess.length;i++){
                for(int j=0;j<chess.length;j++){
                    if(chess[i][j]==0){
                        System.out.print("-\t");
                    }else
                    {
                        System.out.print("q"+chess[i][j]+"\n");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int cell=0;cell<chess.length*chess.length;cell++){
            int row = cell/ chess.length;
            int col = cell% chess.length;

            if(chess[row][col]==0 && IsQueenSafe(chess,row,col)){
                chess[row][col] = qpsf+1;
                nqueens(qpsf+1,tq,chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
