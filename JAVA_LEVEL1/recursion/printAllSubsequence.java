package PEP.JAVA_LEVEL1.recursion;

import java.util.Scanner;

public class printAllSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        printSubsequence(string,"");
    }

    public static void printSubsequence(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        printSubsequence(roq,ans+ch);
        printSubsequence(roq,ans+"");

    }

}
