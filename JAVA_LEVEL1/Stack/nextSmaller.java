package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class nextSmaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of n : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] res=new int[arr.length];
        res=solve(arr);
        System.out.println("Displaing the next smaller element array  : ");
        for(int i:res)
            System.out.println(i);


    }

    private static int[] solve(int[] arr) {  //Solving from end to start using stack
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length-1]);
        res[res.length-1]=-1;
        for(int i= arr.length-1;i>=0;i--){
            if(arr[i]>stack.peek()){
                res[i]=stack.peek();
            }else if(arr[i]<=stack.peek()){
                stack.pop();
                stack.push(arr[i]);
                res[i]=-1;
            }
        }





//        for(int i=arr.length-2;i>=0;i--){       this is the code for next smallest
//            if(!stack.isEmpty() && arr[i]>stack.peek() ){
//                res[i]=stack.peek();
//            }
//            else if(!stack.isEmpty() && arr[i]<= stack.peek()){
//                res[i]=-1;
//                stack.push(arr[i]);
//            }
//        }
        return res;
    }
}
