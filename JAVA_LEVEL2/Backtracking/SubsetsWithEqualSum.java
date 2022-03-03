package PEP.JAVA_LEVEL2.Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetsWithEqualSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }


        int k = sc.nextInt(); // inputted no of partitions

        // if k is equal to 1 , then the whole array is our answer
        if(k==1){
            System.out.print("[");
            for(int val:arr) System.out.print(val+", ");
            System.out.println("]");
            return;
        }
        // if there are more subsets than the no of elements in array
        // or if sum is not a multiple of k the answer is not possible ,
        // hence print -1 and  return

        if(k>n || sum%k!=0){
            System.out.println("-1");
            return;
        }

        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<k;i++){
            ans.add(new ArrayList<>());
        }

        solution(arr,0,n,k,subsetSum,0,ans);
    }

    private static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int sssf, ArrayList<ArrayList<Integer>> ans) {
        if(vidx==arr.length){
            if(sssf == k){
                boolean flag = true;
                for(int i=0;i<subsetSum.length-1;i++){
                    if(subsetSum[i]!=subsetSum[i+1]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(ArrayList<Integer> partition : ans){
                        System.out.print(partition+" ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size()>0){
                ans.get(i).add(arr[vidx]);
                subsetSum[i]+=arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,sssf,ans);
                subsetSum[i]-=arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
            }else{
                ans.get(i).add(arr[vidx]);
                subsetSum[i]+=arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,sssf+1,ans);
                subsetSum[i]-=arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }
    }


}
