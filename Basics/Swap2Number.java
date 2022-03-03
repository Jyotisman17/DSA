package PEP.Basics;

public class Swap2Number {
    public static void main(String[] args) {
        int a=10,b=20;
        System.out.println("Before swapping the values are "+a+" "+b);
        //using a third variable
//        int temp = a;
//        a=b;
//        b=temp;

        //using + and - operator
//        a=a+b;
//        b=a-b;
//        a=a-b;

        //using * and / operator but here none of the values should be zero
//        a=a*b;
//        b=a/b;
//        a=a/b;

        //using xor operator
//        a=a^b;
//        b=a^b;
//        a=a^b;

        //using a single statement
        b=a+b-(a=b);

        System.out.println("After swapping the values are "+a+" "+b);


    }
}
