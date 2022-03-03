package PEP.JAVA_LEVEL1.Two_D_Arrays;

import java.util.Scanner;


public class operations {
    static Scanner sc = new Scanner(System.in);
    public static void diagonalTraversal(int[][] arr){
        for(int g=0;g<arr.length;g++){
            for(int i=0,j=g;j<arr.length;i++,j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    public static void saddlePoint(int[][] arr){
        // lowest value in row and highest value in column is defined as saddle point
        for(int i=0;i<arr.length;i++){
            int lci=0;
            for(int j=1;j<arr[0].length;j++){
                if(arr[i][j]<arr[i][lci])lci=j;
            }
            boolean flag = true;
            for(int k=0;k<arr.length;k++){
                if(arr[k][lci]>arr[i][lci]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("Saddle Point : "+ arr[i][lci]);
                return;
            }
        }
        System.out.println("No saddle point for this input ");
    }

    public static void searchInASortedArray(int[][] arr,int k){
        int i=0;
        int j=arr[0].length-1;
        while(i<j){
            if(arr[i][j]==k) {
                System.out.println(i + "\n" + j);
                break;
            }
            else if(arr[i][j]<k)
                i++;
            else if(arr[i][j]>k)
                j--;
        }
        System.out.println("Not Found");
    }
    public static void main(String[] args) {
        int[][] arr = Multiplication.construct2DMatrix();
        Multiplication.display(arr);
        System.out.println("Enter the element you want to search : ");
        int searchElement = sc.nextInt();
        searchInASortedArray(arr,searchElement);
//        saddlePoint(arr);
//        Multiplication.display(arr);
//        diagonalTraversal(arr);



    }
}
