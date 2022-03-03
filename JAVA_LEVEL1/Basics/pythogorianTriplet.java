package PEP.JAVA_LEVEL1.Basics;

import java.util.Scanner;

public class pythogorianTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=sc.nextInt();  // input 1
        int num2=sc.nextInt();  // input 2
        int num3=sc.nextInt();  // input 3
        int max=num1;  // considering
        if(num2>max)max=num2;
        if(num3>max)max=num3;

        // comparing and if true then printing the result
        if(max==num1){
            boolean result = ((num1 * num1)==((num2*num2)+(num3*num3)));
            System.out.println(result);
        }else if(max==num2){
            boolean result = ((num2*num2)==((num1*num1)+(num3*num3)));
            System.out.println(result);
        }else if(max==num3){
            boolean result = ((num3*num3)==((num1*num1)+(num2*num2)));
            System.out.println(result);
        }
    }
}
