package PEP.JAVA_LEVEL1.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class getElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the first array : ");
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        System.out.println("Enter the value for the first array : ");
        for(int i=0;i<n1;i++) a1[i]=sc.nextInt();

        System.out.println("Enter the size of the second array : ");
        int n2=sc.nextInt();
        int[] a2= new int[n2];
        System.out.println("Enter the value for the second array : ");
        for(int i=0;i<n2;i++) a2[i]=sc.nextInt();

        HashMap<Integer,Integer> fmap = new HashMap<>();
        for(int val:a1){
            if(fmap.containsKey(val)){
                fmap.put(val,fmap.get(val)+1);
            }else{
                fmap.put(val,1);
            }
        }

        for(int val:a2){
            if(fmap.containsKey(val) && fmap.get(val)>0){
                System.out.println(val);
                fmap.put(val,fmap.get(val)-1);
            }
        }



    }
}
