package PEP.JAVA_LEVEL2.Backtracking;

import java.util.Scanner;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solutions(str,"");
    }
    public static void solutions(String str , String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        for(int i=0;i<str.length();i++){
            String prefix = str.substring(0,i+1); // here we will get the prefix
            String ros = str.substring(i+1);
            if(isPalindrome(prefix)){
                solutions(ros,asf+"("+prefix+")");
            }
        }

    }

    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            char lc = str.charAt(left);
            char rc = str.charAt(right);
            if(lc!=rc)return false;
            left++;
            right--;
        }
        return true;
    }


}
