package PEP.JAVA_LEVEL1.Basics;

import java.util.Scanner;

public class rotateNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();  // inputted digit
        int rotateBy=sc.nextInt(); // how much to rotate
        int nod=countDigit(num);  // it will return the no of digits in the inputted num
        rotateBy=rotateBy%nod;  // to reduce the larger rotation to required rotation
        if(rotateBy<0) // it will handle the negative inputs
            rotateBy=nod-rotateBy;

        int div=(int) Math.pow(10,rotateBy);
        int mul=(int) Math.pow(10,nod-rotateBy);
        int temp=num%div; // it will pick the rotation nums
        num=num/div;  // it will separate the left portion
        temp*=mul;  // it will take the right portion to the front
        temp+=num; // then it will add the left portion to the right
        System.out.println(temp);
    }


    protected static int countDigit(int n){
        if(n/10==0)
            return 1;
        return 1+countDigit(n/10);
    }
}
