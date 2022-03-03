package PEP.JAVA_LEVEL1.NumberSystem;

import java.util.Scanner;

public class anyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int  destBase= scn.nextInt();

        int result=getValue(n,sourceBase,destBase);
        System.out.println(result);
    }
    public static int getValue(int n,int sourceBase,int destBase){
        int decimalValue=getValueIndecimal(n,sourceBase);
        int result = getValueInDecimalToAnyBase(decimalValue,destBase);
        return result;
    }
    public static int getValueIndecimal(int n, int b){
        // write your code here
        int result = 0;
        int power = 1;
        while(n!=0){
            int dig = n%10;
            n/=10;

            result += dig*power;
            power*=b;
        }
        return result;
    }
    public static int getValueInDecimalToAnyBase(int n, int b){
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
