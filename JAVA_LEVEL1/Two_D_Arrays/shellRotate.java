package PEP.JAVA_LEVEL1.Two_D_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class shellRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = Multiplication.construct2DMatrix();
        int s = sc.nextInt();
        int r = sc.nextInt();
        System.out.println("Array before shell rotation");
        Multiplication.display(arr);

        rotateShell(arr,s,r);

        System.out.println("\n\nArray after shell rotation ");
        Multiplication.display(arr);
    }

    private static void rotateShell(int[][] arr, int s, int r) {
        int[] oned = fillOneDFromShell(arr,s);
        rotate(oned,r);
        fillShellFromOned(arr,s,oned);
    }

    public static int[] fillOneDFromShell(int[][] arr,int s){
        int minr = s-1;
        int minc = s-1;
        int maxr=arr.length-s;
        int maxc=arr[0].length-s;

        int size = 2*(maxr-minr+maxc-minc);

        int[] oned = new int[size];
        int idx=0;
        // left wall
        for(int i=minr,j=minc;i<=maxr;i++) oned[idx++] = arr[i][j];
        //bottom wall
        for(int i=maxr,j=minc+1;j<=maxc;j++)oned[idx++] = arr[i][j];
        //right wall
        for(int i=maxr-1,j=maxc;i>=minr;i--)oned[idx++] = arr[i][j];
        //top wall
        for(int i=minr,j=maxc-1;j>=minc+1;j--)oned[idx++] = arr[i][j];

        System.out.println("\nThe correspondint 1-D array is : "+ Arrays.toString(oned));
        return oned;

    }
    public static void fillShellFromOned(int[][] arr,int s,int[] oned){
        int minr = s-1;
        int minc = s-1;
        int maxr=arr.length-s;
        int maxc=arr[0].length-s;

        int size = 2*(maxr-minr+maxc-minc);

        int idx=0;
        // left wall
        for(int i=minr,j=minc;i<=maxr;i++) arr[i][j]=oned[idx++];
        //bottom wall
        for(int i=maxr,j=minc+1;j<=maxc;j++)arr[i][j]=oned[idx++];
        //right wall
        for(int i=maxr-1,j=maxc;i>=minr;i--)arr[i][j]=oned[idx++];
        //top wall
        for(int i=minr,j=maxc-1;j>=minc+1;j--)arr[i][j]=oned[idx++];

    }
    public static void rotate(int[] arr,int r){
        r = r % arr.length;  // to handle large rotations
        if(r<0)r=r+arr.length;  // to handle negative inputs
        reverse(arr,0,arr.length-r-1);
        reverse(arr,arr.length-r,arr.length-1);
        reverse(arr,0,arr.length-1);

    }
    public static void reverse(int[] arr, int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
