package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class OneRepeatingOneMissing {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr){
        //write your code here
        int xor = 0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
        }
        for(int i=1;i<=arr.length;i++){
            xor^=i;
        }

        int rsb = xor & -xor;

        int x = 0 ;
        int y = 0 ;

        for(int val:arr){
            if ((val & rsb) == 0) {
                x^=val;
            } else {
                y^=val;
            }
        }
        for(int val=1;val<=arr.length;val++){
            if ((val & rsb) == 0) {
                x^=val;
            } else {
                y^=val;
            }
        }

        for(int val:arr){
            if(val==x){
                System.out.println("Missing Number -> "+y);
                System.out.println("Repeating Number -> "+x);
                break;
            }else if(val==y){
                System.out.println("Missing Number -> "+x);
                System.out.println("Repeating Number -> "+y);
                break;
            }
        }

    }
}
