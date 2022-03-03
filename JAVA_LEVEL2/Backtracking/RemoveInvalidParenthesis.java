package PEP.JAVA_LEVEL2.Backtracking;

import java.util.*;

public class RemoveInvalidParenthesis {

    public static void solution(String str, int mra, HashSet<String> ans) {
        //write your code here
        if(mra==0){
            if(getMin(str)==0){
                if(!ans.contains(str)) { // to avoid same string printing multiple times
                    System.out.println(str);
                    ans.add(str);
                }
            }
            return;
        }
        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i+1);   // by doing this we are removing ith character
            solution(left+right,mra-1,ans);
        }
    }

    public static int getMin(String str){
        //write your code here
        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                st.push('(');
            }else if(ch==')'){
                if(st.size()==0)st.push(')');
                else if(st.peek()==')')st.push(')');
                else if(st.peek()=='(')st.pop();
            }
        }
        return st.size();
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int mr = getMin(str); // minimum removal
        solution(str,mr,new HashSet<>());
    }

}