package PEP.Basics;
import java.util.*;

public class reverseNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int num=sc.nextInt();

        //using Simple Alggorithm
//        int rev=0;
//        while(num!=0){
//            rev=rev*10+num%10;
//            num/=10;
//        }

        //using StringBuffer class
//        StringBuffer ob = new StringBuffer(String.valueOf(num));
//        StringBuffer rev = ob.reverse();

        //using StringBuilder class
        StringBuilder ob = new StringBuilder();
        ob.append(num);
        StringBuilder rev = ob.reverse();

        System.out.println("Reversed input number is "+rev);
    }
}
