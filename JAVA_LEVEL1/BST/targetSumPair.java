package PEP.JAVA_LEVEL1.BST;

import java.io.*;
import java.util.*;

public class targetSumPair {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static boolean find(Node node, int data) {
        if(node==null)return false;
        if (data > node.data) {
            return find(node.right,data);
        } else if (data < node.data) {
            return find(node.left,data);
        }else
        {
            return true;
        }

    }
    public static void travelAndPrint(Node root ,Node node,int tar){
        if(node==null)return;
        travelAndPrint(root , node.left,tar);
        int comp = tar-node.data;
        if(node.data<comp)
            if(find(root, comp))
                System.out.println(node.data + " "+comp);
        travelAndPrint(root,node.right,tar);
    }

    public static void travelAndFindUsingArrayList(Node node,ArrayList<Integer> list){
        if(node==null)return;
        travelAndFindUsingArrayList(node.left,list);
        list.add(node.data);
        travelAndFindUsingArrayList(node.right,list);

    }

    public static class ITPair{
        Node node;
        int state;

        ITPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void bestApproach(Node root,int tar){
        Stack<ITPair> ls = new Stack<>();
        Stack<ITPair> rs = new Stack<>();
        ls.push(new ITPair(root,0));
        rs.push(new ITPair(root,0));
        Node left = getNextFromNormalInOrder(ls);
        Node right = getNextFromReverseInorder(rs);
        while (left.data < right.data) {
            if(left.data + right.data < tar){
                left = getNextFromNormalInOrder(ls);
            }else if(left.data + right.data > tar) {
                right = getNextFromReverseInorder(rs);
            }
            else {
                System.out.println(left.data +" "+ right.data);
                left = getNextFromNormalInOrder(ls);
                right = getNextFromReverseInorder(rs);

            }
        }
    }

    public static  Node getNextFromNormalInOrder(Stack<ITPair> st){
        while(st.size()>0){
            ITPair top = st.peek();
            if(top.state==0){ // preorder
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left,0));
                }
                top.state++;
            }else if(top.state==1){ // inorder
                if(top.node.right!=null){
                    st.push(new ITPair(top.node.right,0));
                }
                top.state++;
                return top.node;
            }else { // post order
                st.pop();
            }
        }
        return null;
    }

    public static  Node getNextFromReverseInorder(Stack<ITPair> st){
        while(st.size()>0){
            ITPair top = st.peek();
            if(top.state==0){ // preorder
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right,0));
                }
                top.state++;
            }else if(top.state==1){ // inorder
                if(top.node.left!=null){
                    st.push(new ITPair(top.node.left,0));
                }
                top.state++;
                return top.node;
            }else { // post order
                st.pop();
            }
        }
        return null;
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        // write your code here
        travelAndPrint(root,root,data);

        //using arraylist , ( Method 2 ) -->
        ArrayList<Integer> list = new ArrayList<>();
        travelAndFindUsingArrayList(root,list);
        int li = 0;
        int ri = list.size()-1;
        while (li < ri) {
            int left = list.get(li);
            int right = list.get(ri);
            if(left+right>data){
                ri--;
            }else if(left+right<data){
                li++;
            }else {
                System.out.println(left+" "+right);
                li++;
                ri--;
            }

        }
    }

}