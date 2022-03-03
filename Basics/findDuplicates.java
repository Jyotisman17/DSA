package PEP.Basics;

import java.util.HashSet;

public class findDuplicates {
    public static void main(String[] args) {
        String []arr={"Jyotis","Jyotisman","Jyotisi"};
        //using Iterative approach
//        boolean flag = false;
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[i].equals(arr[j])){
//                    flag = true;
//                    break;
//                }
//            }
//        }
//        if(flag)
//            System.out.println("contain duplicates");
//        else
//            System.out.println("doesnot contains Duplicates ");

        //using HashSet
        boolean ans = isDuplicate(arr);
        if(ans) System.out.println("Contains Duplicates ");
        else System.out.println("doesnot contains duplicates ");

    }

    private static boolean isDuplicate(String[] arr) {
        if(arr.length==0 || arr.length==1)return false;
        HashSet<String> hashSet = new HashSet<String>();
        for(String values : arr)
            if(!hashSet.add(values))return true;
        return false;
    }
}
