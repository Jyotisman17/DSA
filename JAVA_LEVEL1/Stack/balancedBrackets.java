package PEP.JAVA_LEVEL1.Stack;


import java.util.Scanner;
import java.util.Stack;

public class balancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean flag = true;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if(ch==')')ch='(';
                else if(ch=='}')ch='{';
                else ch='[';
                flag = checkClosing(st, ch);
                if (!flag) {
                    System.out.println(false);
                    return;
                }
            }
        }
        if(st.isEmpty()) System.out.println(true);
        else System.out.println(false);
    }
    protected static boolean checkClosing(Stack<Character>st,char c){
        if(st.size()==0)return false;
        if(st.peek()!=c) return false;
        else {
            st.pop();
            return true;
        }
    }
}
