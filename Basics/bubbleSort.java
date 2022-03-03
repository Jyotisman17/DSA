package PEP.Basics;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int []arr={3,1,78,32,2};
        System.out.println("Array before sort is "+Arrays.toString(arr));
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]+arr[j+1];
                    arr[j+1]=arr[j]-arr[j+1];
                    arr[j]= arr[j]-arr[j+1];
                }
            }
        }
        System.out.println("Array after sort is : "+Arrays.toString(arr));
    }
}
