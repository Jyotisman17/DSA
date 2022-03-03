package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class prefixConvEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an prefix expression : ");
        String exp = sc.nextLine();

        //code

        Stack<Integer> vs = new Stack<>();
        Stack<String>is = new Stack<>();
        Stack<String>ps = new Stack<>();

        for(int i=exp.length()-1;i>=0;i--){
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)){
                vs.push(ch-'0');
                is.push(ch+"");
                ps.push(ch+"");
            }
            else{
                int v1=vs.pop();
                int v2=vs.pop();
                int val=operation(v1,v2,ch);
                vs.push(val);

                String iv1=is.pop();
                String iv2=is.pop();
                String ival="("+iv1+ch+iv2+")";
                is.push(ival);

                String pv1=ps.pop();
                String pv2=ps.pop();
                String pval=pv1+pv2+ch;

                ps.push(pval);

            }
        }
        System.out.println("Result is :" + vs.pop());
        System.out.println("Infix value is :"+is.pop());
        System.out.println("Prefix value is :"+ps.pop());

    }
    public static int operation(int v1,int v2,char op) {
        if(op=='+')return v1+v2;
        else if(op=='-')return v1-v2;
        else if(op=='*')return v1*v2;
        else return v1/v2;
    }
}
