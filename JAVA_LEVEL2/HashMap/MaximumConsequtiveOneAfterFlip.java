package PEP.JAVA_LEVEL2.HashMap;

import java.util.Scanner;

public class MaximumConsequtiveOneAfterFlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(arr,k));
    }
    public static int solution(int[] arr, int k){
        int ans = 0;
        int j=-1;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)count++;
            while(count>k){
                j++;
                if(arr[j]==0)count--;
            }
            int len = i-j;
            if(len>ans)ans=len;
        }
        return ans;
    }
}
