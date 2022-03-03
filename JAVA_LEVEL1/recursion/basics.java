package PEP.JAVA_LEVEL1.recursion;

import java.util.Scanner;

public class basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number to print increasingly upto that num  :");
//        int inc = sc.nextInt();
//        System.out.println("Printing increasingly : ");
//        printIncreasingly(inc);
//        System.out.println("Enter a number to print decreasingly from number to zero :");
//        int dec = sc.nextInt();
//        System.out.println("Printing decreasingly : ");
//        printDecreasingly(dec);
//        System.out.println();
//        System.out.println("Enter a number to print decresingly than increasinglyl ");
//        int num = sc.nextInt();
//        System.out.println("Printing the values : ");
//        printDecreasingIncreasing(num);

//        System.out.println("Enter a number to find its factorial : ");
//        int fac = sc.nextInt();
//        int facValue = factorial(fac);
//        System.out.println("Factorial : "+facValue);

//        System.out.println("Enter x and n value to calculate power : ");
//        int x = sc.nextInt();
//        int n = sc.nextInt();
//        int value = powerplus(x,n);
//        System.out.println("Result : "+ value);
//        System.out.println("Time :"+checkTime);

        printZigZag(2);


    }

    public static void printZigZag(int a){
        if(a==0)return;
        System.out.println("pre "+a);
        printZigZag(a-1);
        System.out.println("In "+a);
        printZigZag(a-1);
        System.out.println("Post "+a);
    }
    public static void printIncreasingly(int n){
        if(n==0)return;
        printIncreasingly(n-1);
        System.out.println(n);
    }

    static int checkTime = 0;

    public static void printDecreasingly(int n) {
        if(n==0)return;
        System.out.println(n);
        printDecreasingly(n-1);
    }

    public static void printDecreasingIncreasing(int n){
        if(n==0)return;
        System.out.println(n);
        printDecreasingIncreasing(n-1);
        System.out.println(n);
    }

    public static int factorial(int num){
        if(num==1)return 1;
        return num*factorial(num-1);
    }

    public static int power(int x,int n){
        checkTime++;
        if(n==0)return 1;
        int num = x*power(x,n-1);
        return num;
    }

    public static int powerplus(int x,int n){// uses a better approach to find the exponential value

        checkTime++;
        if(n==0)return 1;
        int num = powerplus(x, n/2)*powerplus(x,n/2);
        if(n%2==1) num *= x;
        return num;
    }
}
