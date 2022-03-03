package PEP.JAVA_LEVEL1.Two_D_Arrays;

import java.util.*;

public class rotateBy90 {
    static Scanner sc = new Scanner(System.in);
    public static void transpose(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    public static void reverseRow(int[][] arr){
        for(int i=0;i<arr.length;i++){
            int start=0;
            int end=arr[0].length-1;
            while(start<end){
                int temp = arr[i][start];
                arr[i][start]=arr[i][end];
                arr[i][end]= temp;
                start++;
                end--;
            }
        }
    }

    public static int[][] construct2DMatrix(){
        int[][] arr ;
        int row = sc.nextInt();
        int col = sc.nextInt();
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }



    public static void main(String[] args) throws Exception {
        // write your code here
        int[][] arr = construct2DMatrix();
        transpose(arr);
        reverseRow(arr);
        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}