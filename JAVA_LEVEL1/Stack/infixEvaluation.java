package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class infixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Make sure you enter digits based on single digit or else it will print wrong output");
        System.out.println("Enter an expression : ");
        String exp = sc.nextLine();

        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);

            if(ch=='('){
                optors.push(ch);
            }else if(Character.isDigit(ch)){
                opnds.push(ch-'0');  // char to int
            }else if(ch==')'){
                while(optors.peek()!='('){
                    char optor=optors.pop();
                    int val2=opnds.pop();
                    int val1=opnds.pop();
                    int opv = operation(val1,val2,optor);
                    opnds.push(opv);
                }
                optors.pop();
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                // ch wants to solve the operator with higher or same priority operator
                while(!optors.isEmpty() && optors.peek()!='('&&precedence(ch)<=precedence(optors.peek())){
                    char optor=optors.pop();
                    int val2=opnds.pop();
                    int val1=opnds.pop();
                    int opv = operation(val1,val2,optor);
                    opnds.push(opv);
                }
                optors.push(ch);
            }
        }
        while(!optors.isEmpty()){
            char optor=optors.pop();
            int val2=opnds.pop();
            int val1=opnds.pop();
            int opv = operation(val1,val2,optor);
            opnds.push(opv);
        }
        System.out.println(opnds.peek());
    }
    public static int precedence(char operator){
        if(operator=='+')return 1;
        else if(operator=='-')return 1;
        else if(operator=='*')return 2;
        else if(operator=='/')return 2;
        return 0;
    }
    public static int operation(int val1 , int val2, char operator){
        if(operator=='+')return val1+val2;
        else if(operator=='-')return val1-val2;
        else if(operator=='*')return val1*val2;
        else if(operator=='/')return val1/val2;
        return 0;
    }


}
