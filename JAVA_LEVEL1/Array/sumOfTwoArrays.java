package PEP.JAVA_LEVEL1.Array;

import java.util.Scanner;

public class sumOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1=sc.nextInt();  // first array
        int[] a1 = new int[n1];
        for(int i=0;i<a1.length;i++)
            a1[i]=sc.nextInt();

        int n2=sc.nextInt();  // second array
        int[] a2 = new int[n2];
        for(int i=0;i<a2.length;i++)
            a2[i]=sc.nextInt();

//        int[] sum = new int[(int) Math.max(n1, n2)];
        int []sum = new int[n1>n2?n1:n2];
        int c=0;

        int i=a1.length-1;
        int j=a2.length-1;
        int k=sum.length-1;
        while(k>=0){
            int sumvalue=c;
            if(i>=0){
                sumvalue+=a1[i--];
            }
            if(j>=0){
                sumvalue+=a2[j--];
            }
            c = sumvalue/10;
            sumvalue%=10;

            sum[k--]=sumvalue;
        }
        if(c!=0)
            System.out.print(c);
        for(int temp:sum)
            System.out.print(temp);


    }
}
