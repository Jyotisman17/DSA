package PEP.Basics;

public class arrayEqualCheck {
    public static void main(String[] args) {
        int arr1[]={1,2,3,2,5};
        int arr2[]={1,2,3,2,5,5};

        //using Arrays.equals
//        if(Arrays.equals(arr1,arr2)) System.out.println("Both the arrays are equal");
//        else System.out.println("Arrays are not equal");

        //using iterative approach
        if(checkEquality(arr1,arr2)) System.out.println("Arrays are Equal");
        else System.out.println("Arrays are not equal ");
    }

    private static boolean checkEquality(int[] arr1, int[] arr2) {
        if(arr1.length!= arr2.length)return false;
        for(int i=0;i<arr1.length;i++)if(arr1[i]!=arr2[i])return false;
        return true;
    }
}
