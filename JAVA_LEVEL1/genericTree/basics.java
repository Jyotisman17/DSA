package PEP.JAVA_LEVEL1.genericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class basics {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node){
        String str = node.data + "-->";
        for(Node child:node.children){
            str+=child.data + ",";
        }
        str+=".";
        System.out.println(str);
        for(Node child:node.children)
            display(child);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many input you want to give  : ");
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        Node root=null;
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if(!st.isEmpty()){
                    st.peek().children.add(t);
                }else{
                    root=t;
                }
                st.push(t);
            }
        }
        display(root);


    }
}

