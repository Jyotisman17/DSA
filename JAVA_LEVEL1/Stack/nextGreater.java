package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class nextGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arr[] = new int[num];
        for(int i=0;i<num;i++)arr[i]=sc.nextInt();
        int res[] = solve(arr);
        display(res);
    }
    protected static int[] solve(int[] arr){
        int []res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length-1]);
        res[arr.length-1]=-1;
        for(int i=arr.length-2;i>=0;i--){
            while(stack.size()!=0 && stack.peek()<=arr[i] ){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    protected static void display(int[] arr){
        for(int i:arr)
            System.out.println(i+" ");
    }
}
