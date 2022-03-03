package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class stockSpan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of stocks : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] span = solve(arr);
        System.out.println("Displaing the span array : ");
        for(int i:span)
            System.out.println(i);
    }
    private static int[] solve(int[] arr){
        int[] span = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0]=1;
        for(int i=1;i<arr.length;i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) span[i] = i + 1;
            else span[i] = i - stack.peek();
            stack.push(i);
        }
        return span;
    }

}
