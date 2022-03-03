package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class nextSmalller2 {
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

    private static int[] solve(int[] arr) {//solving from start to end
        int[] res = new int[arr.length];
        Stack<Integer>stack = new Stack<>();
        stack.push(0); // storing the index of the value rather the direct value
        for(int i=1;i<arr.length;i++){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                int pos=stack.peek();
                res[pos]=arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int pos = stack.peek();
            res[pos]=-1;
            stack.pop();
        }
        return res;
    }
}
