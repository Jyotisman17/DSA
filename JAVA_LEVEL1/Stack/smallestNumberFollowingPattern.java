package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class smallestNumberFollowingPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //code

        Stack<Integer> st = new Stack<>();
        int num = 1;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch=='d'){
                st.push(num);
                num++;
            }else{
                st.push(num);
                num++;

                while(!st.isEmpty())
                    System.out.print(st.pop()+" ");
            }
        }
        st.push(num);
        num++;
        while(!st.isEmpty())
            System.out.print(st.pop()+" ");

    }
}
