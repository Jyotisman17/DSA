package PEP.JAVA_LEVEL1.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class slidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        //code
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        stack.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(i);

        }

        System.out.println("Displaing the next greater element array : ");
        for (int i : nge) {
            if (i < arr.length)
                System.out.print(arr[i] + " ");
            else System.out.print("-1");
            }

            System.out.println();

            System.out.println("Printing the answer for sliding window maximum \n");
            int j = 0;
            for (int i = 0; i <= arr.length - k; i++) {
                if (j < i) j = i;
                while (nge[j] < i + k) {
                    j = nge[j];
                }
                System.out.print(arr[j] + " ");
            }



    }
}
