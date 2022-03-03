package PEP.JAVA_LEVEL2.Backtracking;

import java.util.Scanner;

public class NQueenBrandAndBound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] board = new boolean[n][n];

        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1]; // r+c
        boolean[] rdiag = new boolean[2*n-1]; // r-c + arr.length-1

        solve(board,0,cols,ndiag,rdiag,"");
    }

    private static void solve(boolean[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag, String asf) {
        if(row==board.length){
            System.out.println(asf+".");
            return;
        }


        for(int col = 0;col<board[0].length;col++){
            if(!cols[col] && !ndiag[row+col] &&!rdiag[row-col +board.length-1]){
                board[row][col]=true; // we can ignore this line , but for logical thinking we are doing this , same in backtracking section also
                cols[col]=true;
                ndiag[row+col]=true;
                rdiag[row-col+board.length-1]=true;
                solve(board,row+1,cols,ndiag,rdiag,asf+row+"-"+col+",");
                // the following 4 lines are used to backtrack
                board[row][col]=false;
                cols[col]=false;
                ndiag[row+col]=false;
                rdiag[row-col+board.length-1]=false;
            }
        }
    }


}
