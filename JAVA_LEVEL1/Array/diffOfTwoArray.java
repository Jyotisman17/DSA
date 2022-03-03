package PEP.JAVA_LEVEL1.Array;

import java.util.Scanner;

public class diffOfTwoArray {
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

        int []diff = new int[n2];
        int c=0;

        int i=a1.length-1;
        int j=a2.length-1;
        int k=diff.length-1;

        while(k>=0){
            int diffValue = 0;
            int a1value=i>=0?a1[i]:0;
            if(a2[j]+c>=a1value){
                diffValue=a2[j--]+c-a1value;
                c=0;
            }else{
                diffValue=a2[j--]+c+10-a1value;
                c=-1;
            }
            diff[k--]=diffValue;
            i--;
        }
        int idx = 0;
        while(idx<diff.length){
            if(diff[idx]==0)
                idx++;
            else
                break;
        }
        while(idx<diff.length)
        {
            System.out.println(diff[idx]);
            idx++;
        }


    }
}
