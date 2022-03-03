package PEP.Basics;

import java.util.*;


public class linearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []arr=new int[10];
        System.out.println("Enter 10 elements for the array : ");
        for(int i=0;i<10;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the elements to search : ");
        int searchElement = sc.nextInt();
        boolean flag = false;
        for(int values=0;values<arr.length;values++)if(arr[values]==searchElement){
            System.out.println("Element found at index : "+values);
            flag=true;
            break;
        }
        if(!flag) System.out.println("Element not found ");
    }
}
