package PEP.JAVA_LEVEL2.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nextGreater {
    static List<Integer> nextPermutation(int N, int[] nums){
        // code here
        List<Integer> l = new ArrayList<>();
        int i=N-2;
        int j=0;
        while(i>=0 && nums[i]>=nums[i+1])i--;
        if(i>=0){ // we can do this
            j=nums.length-1;
            while(nums[j]<=nums[i])j--;
            swap(nums,i,j);
            reverse(nums,i+1,nums.length-1);
            for(int i1=0;i1<N;i1++)l.add(nums[i1]);
        }else{ // we can't do this , hence we will return the sorted list
            for(int i1=0;i1<N;i1++)l.add(nums[i1]);
            Collections.sort(l);
        }
        return l;

    }
    public static void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void reverse(int nums[],int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l=nextPermutation(6, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(l);
    }

}
