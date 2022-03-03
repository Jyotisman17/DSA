package PEP.JAVA_LEVEL1.Array;

import java.util.Scanner;

public class findElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int key = sc.nextInt();
        int idx=-1;
        for(int i=0;i<n;i++){
            if(key==arr[i])
            {
                idx=i;
                break;
            }
        }
        System.out.println(idx);
    }
}
