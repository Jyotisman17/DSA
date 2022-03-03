package PEP.JAVA_LEVEL1.recursion;

import java.util.ArrayList;

public class ArrayOperations {

    public static void main(String[] args) {

        String string = "abc";
        ArrayList<String> list = getSubSequence(string);
        System.out.println(list.toString());
//        int[] arr ={1,2,3,4,5,6,4,3,23,4,2,3,2,3,2,1,3,4,4,3,3,2,3,1,1,};
//        int[] indices = allIndices(arr,3,0,0);
//        System.out.println(Arrays.toString(indices));

//        displayReverse(arr,0);
//        System.out.println("Maximum element in the array are : "+findMax(arr,0));
//        int index = firstIndex(arr,0,3);
//        System.out.println("First index of the data in the array is : "+index);
//        index = lastIndex(arr, 0, 3);
//        System.out.println("Last index of the data in the array is : "+index);

    }

    public static void display(int[] arr, int idx) {
        if(idx==arr.length)return;
        System.out.print(arr[idx]+" ");
        display(arr,idx+1);
    }

    public static void displayReverse(int[] arr, int idx) {
        if(idx==arr.length)return;
        displayReverse(arr,idx+1);
        System.out.print(arr[idx]+" ");
    }
    public static int findMax(int[] arr,int idx){
        if(idx==arr.length)return 0;
        int restMax = findMax(arr,idx+1);
        return Integer.max(restMax,arr[idx]);
    }

    public static int firstIndex(int[] arr,int idx,int data){
        if(idx==arr.length)return -1;
        if(arr[idx]==data)return idx;

        int gotIndex = firstIndex(arr,idx+1,data);
        return gotIndex;
    }

    public static int lastIndex(int[] arr,int idx,int data){
        if(idx==arr.length)return -1;

        int gotIndex=lastIndex(arr,idx+1,data);
        if(gotIndex==-1){
            if(arr[idx]==data)
                return idx;
            else
                return -1;
        }
        return gotIndex;
    }

    public static int[] allIndices(int[] arr,int x,int idx,int fsf){
        if(idx==arr.length){
            return new int[fsf];
        }
        if(arr[idx]==x){
            fsf++;
        }
        int[] temp = allIndices(arr,x,idx+1,fsf);
        if(arr[idx]==x)
            temp[fsf-1]=idx;
        return temp;
    }

    public static ArrayList<String> getSubSequence(String str) {
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> res = getSubSequence(ros);

        ArrayList<String> mres = new ArrayList<>();
        for(String rstr : res){
            mres.add(""+rstr);
        } for(String rstr : res){
            mres.add(ch+rstr);
        }
        return mres;
    }





}
