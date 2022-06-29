package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class MaxSumSubArrayWithAtLeastKSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(arr,k));
    }
    public static int solution(int[] arr,int k){
        int ans = Integer.MIN_VALUE;
        int csum = arr[0];
        int[] maxSum = new int[arr.length];
        maxSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(csum>0){
                csum+=arr[i];
            }else{
                csum=arr[i];
            }
            maxSum[i]=csum;
        }
        int exactK = 0;
        for(int i=0;i<k;i++){ // first window of size k
            exactK+=arr[i];
        }
        ans = exactK;
        for(int i=k;i<arr.length;i++){
            exactK +=( arr[i]-arr[i-k]);
            if(exactK>ans)ans=exactK;
            int atleastK = maxSum[i-k]+exactK;
            if(atleastK>ans)ans=atleastK;

        }


        return ans;
    }
}
