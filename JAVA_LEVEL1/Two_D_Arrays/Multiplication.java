package PEP.JAVA_LEVEL1.Two_D_Arrays;


import java.util.Scanner;

public class Multiplication {
    static Scanner sc = new Scanner(System.in);
    public static int[][] construct2DMatrix(){
        int[][] arr ;
        System.out.println("Enter the No of rows : ");
        int row = sc.nextInt();
        System.out.println("Enter the No of colm : ");
        int col = sc.nextInt();
        arr = new int[row][col];
        System.out.println("Enter the elements for the Two Dimensional Array : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }
    public static boolean canMultiply(int[][] arr1,int[][] arr2) {
        return arr1[0].length == arr2.length;
    }
    public static void display(int [][]arr){
        System.out.println("Displaying the elements of the Two Dimensional Matrix : ");
        for (int[] ints : arr) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }


//            for(int i=0;i<arr.length;i++){           for displaying using one for loop by converting each row into a string
//           System.out.println(Arrays.toString(arr[i]) +" ");
//        }
    }
    public static int[][] matmul(int[][] arr1,int[][] arr2){
        int row =arr1.length;
        int col =arr2[0].length;
        int [][] product = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<arr1[0].length;k++){
                    product[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }

        return product;
    }
    public static void main(String[] args) {
            int [][] array1 = construct2DMatrix();
            display(array1);
            int [][] array2 = construct2DMatrix();
            display(array2);
            boolean check = canMultiply(array1,array2);
            if(check){
                int[][] product = matmul(array1,array2);
                System.out.println("Displaying the Product Matrix  : \n");
                display(product);
            }else
            {
                System.out.println("Sorry , the entered matrices cannot be multiplied as they have not satisfied the row column law of multiplication of two matrix ");
            }


        }
    }
