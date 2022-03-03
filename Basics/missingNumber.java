package PEP.Basics;

public class missingNumber {
    public static void main(String[] args) {
        int arr[]={1,2,4,5,6,7};
        int sum=0,total_sum=0;
        for(int values:arr)sum+=values;
        System.out.println("Sum = "+sum);
        for(int i=1;i<=arr[arr.length-1];i++)total_sum+=i;
        System.out.println("total_sum = "+total_sum);
        System.out.println("Missing digit is "+(total_sum-sum));
    }
}
