package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class CheckDivisibilityBy3 { // we will check by checking the divisibility of the binary string by 11 , which is the binary equivalent of 3
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        //write your code here
        int odd = 0;
        int even = 0;
        for(int i=0;i<str.length();i++){
            if(i%2==0){
                even+=str.charAt(i)-'0';
            }else{
                odd+=str.charAt(i)-'0';
            }
        }
        int delta = even - odd;
        if(delta%11==0){
            System.out.println(true);
        }else
            System.out.println(false);
    }
}
