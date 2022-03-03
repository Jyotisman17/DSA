package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class infixConversion {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression ");
        String exp = sc.nextLine();
        Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch=='('){
                ops.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                post.push(ch+"");
                pre.push(ch+"");
            } else if (ch == ')') {
                while(ops.peek()!='('){
                    process(ops,post,pre);
                }
                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while(!ops.isEmpty() && ops.peek()!='(' && precedence(ch)<= precedence(ops.peek())){
                    process(ops,post,pre);

                }
                ops.push(ch);
            }
        }
        while(ops.size()>0){
            process(ops,post,pre);
        }
        System.out.println("Postfix Expression : "+post.peek());
        System.out.println("Prefix Expression : "+pre.peek());

    }
    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        else return 2;
    }

    public static void process(Stack<Character> ops, Stack<String> post, Stack<String> pre) {
        char op = ops.pop();
        String postv2=post.pop();
        String postv1=post.pop();
        String prev2=pre.pop();
        String prev1=pre.pop();
        String postvalue = postv1+postv2+op;
        String prevalue =op+prev1+prev2;
        post.push(postvalue);
        pre.push(prevalue);
    }
}
