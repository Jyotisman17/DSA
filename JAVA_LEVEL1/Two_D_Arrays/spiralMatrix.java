package PEP.JAVA_LEVEL1.Two_D_Arrays;


public class spiralMatrix {
    public static void main(String[] args) {
        int[][]arr = Multiplication.construct2DMatrix();
        Multiplication.display(arr);
        int minr=0;
        int minc=0;
        int maxr=arr.length-1;
        int maxc=arr[0].length-1;
        int total = arr.length*arr[0].length;
        int count = 0 ;
        while(count<total){
            //left wall
            System.out.println("\nPrinting the left wall");
             for(int i=minr;i<=maxr;i++) {
                 System.out.println(arr[i][minc]);
                 count++;
             }
             if(count>=total)break;
             minc++;
            System.out.println("Printing the bottom wall");
            //bottom wall
            for(int j=minc;j<=maxc;j++) {
                System.out.print(arr[maxr][j]+" ");
                count++;
            }
            if(count>=total)break;
            maxr--;

            //right wall
            System.out.println("\nPrinting the right wall");
            for(int i=maxr;i>=minr;i-- ) {
                System.out.println(arr[i][maxc]);
                count++;
            }
            if(count>=total)break;
            maxc--;

            //top wall
            System.out.println("Printing the top wall");
            for(int j=maxc;j>=minc;j--) {
                System.out.print(arr[minr][j]+" ");
                count++;
            }
            if(count>=total)break;
            minr++;
        }
    }
}
