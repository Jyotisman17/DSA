package PEP.JAVA_LEVEL1.NumberSystem;

import java.util.Scanner;

public class decimalToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }
    public static int getValueInBase(int n, int b){
        // write code here
        int result = 0;
        int power = 1;
        while(n!=0){
            int dig = n%b;
            n/=b;
            result+=dig*power;
            power=power*10;
        }
        return result;
    }
}
