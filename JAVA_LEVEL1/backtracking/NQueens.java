package PEP.JAVA_LEVEL1.backtracking;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess,"",0);
    }
    public static void printNQueens(int[][] chess,String qsf,int row){
        if(row==chess.length){
//            System.out.println(qsf+".");
            for(int i=0;i<chess.length;i++){
                for(int j=0;j< chess.length;j++)
                    System.out.print(chess[i][j]+" ");
                System.out.println();

            }
            System.out.println("\n\n\n\n");

            return;
        }
        for(int col = 0;col<chess.length;col++){
            if(isItSafePlaceForQueen(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }
        }
    }
    public static boolean isItSafePlaceForQueen(int[][] chess , int row , int col){
        for(int i=row-1,j=col;i>=0;i--)
            if(chess[i][j]==1)return false;
        for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--)
            if(chess[i][j]==1)return false;
        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++)
            if(chess[i][j]==1)return false;
        return true;
    }
}
