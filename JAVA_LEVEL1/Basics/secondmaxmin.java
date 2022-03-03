package PEP.JAVA_LEVEL1.Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class secondmaxmin {
    public static void main(String[] args) {
        ArrayList<Integer> num=new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            num.add(sc.nextInt());
        }
        Collections.sort(num);
        System.out.println(num.get(n - 2)+" "+num.get(1));
    }
}
