package PEP.JAVA_LEVEL1.Two_D_Arrays;

public class waveTraversal {
    public static void main(String[] args) {

       int[][]arr = Multiplication.construct2DMatrix();
       Multiplication.display(arr);
        System.out.println("\n\nDisplaying the matrix in wave mode : ");
        for(int j=0;j<arr[0].length;j++){
            if(j%2==0){
                for(int i=0;i<arr.length;i++)
                    System.out.print(arr[i][j]+" ");
                System.out.println();
            }else{
                for(int i=arr.length-1;i>=0;i--)
                    System.out.print(arr[i][j]+" ");
                System.out.println();
            }
        }

    }
}
