package PEP.JAVA_LEVEL1.Greedy;

import java.util.Scanner;

public class MaxmSumNonAdj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<arr.length;i++)
            arr[i]=sc.nextInt();

        int inc = arr[0];
        int exc = 0;

        for(int i=1;i<arr.length;i++){
            int ninc = exc + arr[i];
            int nexc = Math.max(inc,exc);

            inc = ninc;
            exc = nexc;
        }

        System.out.println(Math.max(inc,exc));
    }
}
