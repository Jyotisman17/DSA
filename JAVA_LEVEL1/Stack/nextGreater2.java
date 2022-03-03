package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class nextGreater2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] res = solve(arr);
        display(res);
    }
    protected static void display(int[] arr){
        for(int i:arr) System.out.println(i);
    }
    protected static int[] solve(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int res[]=new int[arr.length];
        stack.push(0);
        for(int i=1;i<arr.length;i++){
            while(stack.size()>0 && arr[i]>arr[stack.peek()]){
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
