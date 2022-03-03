package PEP.JAVA_LEVEL1.recursion;

import java.util.Scanner;

public class printPermutation {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String str = sc.next();
         printPermutations(str,"");
    }
    public static void printPermutations(String ques,String ssf){
        if(ques.length()==0){
            System.out.println(ssf);
            return;
        }
        for(int i=0;i<ques.length();i++){
            char ch=ques.charAt(i);
            String str=ques.substring(0,i)+ ques.substring(i+1);
            printPermutations(str,ssf+ch);
        }
    }
}
