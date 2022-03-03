package PEP.Basics;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 110};
        //index :    0  1  2  3  4  5  6  7  8   9
        System.out.println("Enter the element you want to search : ");
        int searchElement = sc.nextInt();

        //using Inbuilt binary Search
        int index = Arrays.binarySearch(arr,searchElement);
        if(index>=0){
            System.out.println("Element found at index : "+index);
        }else
            System.out.println("Element not found !");



        //Using Binary Search Manually
//        int low=0,high=arr.length-1;
//        boolean flag = false;
//        while(low<=high){
//            int mid = low+(high-low)/2;
//            if(arr[mid]==searchElement){
//                System.out.println("Element found at index "+mid);
//                flag=true;
//                break;
//            }
//            else if(arr[mid]>searchElement)high=mid-1;
//            else low=mid+1;
//
//        }
//        if(!flag) System.out.println("Element not found !");


    }
}
