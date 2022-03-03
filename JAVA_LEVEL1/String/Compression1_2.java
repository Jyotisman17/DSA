package PEP.JAVA_LEVEL1.String;

import java.util.Scanner;

public class Compression1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
    public static String compression1(String str){
        String s = String.valueOf(str.charAt(0));  // holds first character
        for(int i=1;i<str.length();i++){ // loop to traverse whole string
            char curr = str.charAt(i);   // current value
            char prev = str.charAt(i-1);  // previous value
            if(curr!=prev)s+=curr;  // add to the returned string
        }
        return s;
    }

    public static String compression2(String str){
        String s = String.valueOf(str.charAt(0)); // holds the first character
        int count=1; // count
        for(int i=1;i<str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(curr!=prev){
                if(count>1){
                    s+=count;
                    count=1;
                }
                s+=curr;
            }else{
                count++;
            }
        }
        if(count>1)s+=count;
        return s;
    }
}
