package PEP.JAVA_LEVEL2.NQueensRelated;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// In this code box will choose queen whether it will be placed or not
public class QueenCombinationOne { // This  is not similar to n queen problem
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queenCombination(0,n,0,0,"");
    }

    public static void queenCombination(int qpsf,int tq,int row,int col,String asf){

        if(row==tq){
            if(qpsf==tq)
                System.out.println(asf);
            return;
        }
        int nr = 0;
        int nc = 0;
        String yasf = "";
        String nasf = "";
        if(col==tq-1){ // last column
            nr = row+1;
            nc = 0;
            yasf=asf+"q\n";
            nasf=asf+"-\n";
        }else{
            nr=row;
            nc = col+1;
            yasf=asf+"q";
            nasf=asf+"-";
        }
        queenCombination(qpsf+1,tq,nr,nc,yasf);
        queenCombination(qpsf+0,tq,nr,nc,nasf);

    }
}
