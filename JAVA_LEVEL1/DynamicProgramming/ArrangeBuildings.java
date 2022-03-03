package PEP.JAVA_LEVEL1.DynamicProgramming;
import java.util.*;

public class ArrangeBuildings{

    public static int getval(int n ){
        if(n==0||n==1)return n;
        return getval(n-1)+getval(n-2);
    }
    public static void main(String[] args) {
        // using a self created approach
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // here we will fibonacci approach



        int val1 = getval(n);
        int val2 = getval(n+1);
        long res = (val1+val2);
        System.out.println(res*res);
    }
}
