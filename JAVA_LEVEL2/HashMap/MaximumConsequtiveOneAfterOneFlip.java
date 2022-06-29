package PEP.JAVA_LEVEL2.HashMap;

import java.util.Scanner;

public class MaximumConsequtiveOneAfterOneFlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr){
        int ans = 0;
        int j=-1;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)count++;
            if(count>1){
                j++;
                if(arr[j]==0)count--;
            }
            int len = i-j;
            if(len>ans)ans=len;
        }
        return ans;
    }
}
