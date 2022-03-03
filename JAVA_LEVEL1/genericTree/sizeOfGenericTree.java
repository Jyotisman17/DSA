package PEP.JAVA_LEVEL1.genericTree;

import java.io.*;
import java.util.*;

public class sizeOfGenericTree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){}
        Node(int data){
            this.data=data;
        }
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node){
        // write your code here
        int s=0;
        for(Node child:node.children){
            int cs=size(child);
            s=s+cs;
        }
        s=s+1;
        return s;
    }
    public static int max(Node node) {
        // write your code here
        int max = Integer.MIN_VALUE;
        for(Node child:node.children){
            int cm=max(child);
            max=Math.max(cm,max);
        }
        return Math.max(node.data,max);
    }

    public static int height(Node node) {
        // write your code here
        int height = -1;
        for(Node child:node.children){
            int childHeight = height(child);
            height=Math.max(childHeight,height);
        }
        return height+1;

    }
    public static void traversals(Node node){
        // write your code here

        System.out.println("Node Pre "+node.data); //pre area of the generic tree
        for(Node child:node.children){
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traversals(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);

        }
        System.out.println("Node Post "+node.data); //post area of the generic tree
    }

    public static void levelOrder(Node node){ // in one line
        // write your code here
        Queue <Node>q = new ArrayDeque<>();
        q.add(node);
        while(!q.isEmpty()){
            node=q.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                q.add(child);
            }
        }
        System.out.print(".");
    }

    public static void levelOrderLinewise(Node node){
        // write your code here
        Queue<Node> cQ = new ArrayDeque<>();
        Queue<Node> mQ = new ArrayDeque<>();
        mQ.add(node);
        while(!mQ.isEmpty()){
            node = mQ.remove();
            System.out.print(node.data+" ");

            for(Node child:node.children)
                cQ.add(child);

            if(mQ.isEmpty()){
                mQ=cQ;
                cQ=new ArrayDeque<>();
                System.out.println();
            }

        }

    }

    public static void levelOrderLinewise2(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        queue.add(new Node(-1));
        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.data!=-1)
                System.out.print(node.data + " ");
            else {
                System.out.println();
                queue.add(new Node(-1));
            }
            for(Node child:node.children)
                queue.add(child);
        }
    }

    public static void levelOrderLinewise3(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        int size = q.size();
        while(q.size()!=0){
            size=q.size();
            for(int i=0;i<size;i++){
                node = q.remove();
                System.out.print(node.data+" ");
                for(Node child:node.children)q.add(child);
            }
            System.out.println();
        }
    }
    private static class Pair{
        Node node;
        int level;

        Pair(){}

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static void levelOrderLinewise4(Node node){
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(node,1));
        int level = 1;
        while(!mq.isEmpty()){
            Pair p = mq.remove();
            if(p.level> level){
                System.out.println();
                level++;
            }
            System.out.print(p.node.data+" ");
            for(Node child:p.node.children){
                Pair cp = new Pair(child,level+1);
                mq.add(cp);
            }
        }
    }
    public static void levelOrderLinewiseZZ(Node node){
        // write your code here
        Stack<Node> mainS = new Stack<>();
        Stack<Node> childS = new Stack<>();
        mainS.add(node);
        boolean isEven=false;
        while(!mainS.isEmpty()){
            node=mainS.pop();
            System.out.print(node.data+" ");
            if(isEven)
                for(int i=node.children.size()-1;i>=0;i--)
                    childS.add(node.children.get(i));
            else
                for(Node child:node.children)
                    childS.add(child);
            if(mainS.isEmpty()){
                mainS=childS;
                isEven=!isEven;
                childS=new Stack<>();
                System.out.println();
            }
        }


    }
    public static void removeLeaves(Node node) {
        // write your code here
        for(int i=node.children.size()-1;i>=0;i--){
            Node child = node.children.get(i);
            if(child.children.size()==0)node.children.remove(child);
        }
        for(Node child:node.children)removeLeaves(child);
    }

    public static void mirror(Node node){
        // write your code here
        for(Node child:node.children)mirror(child);
        Collections.reverse(node.children);
    }

    public static void linearize(Node node){
        // write your code here

        for(Node child:node.children)
            linearize(child);

        while(node.children.size()>1){
            Node lc = node.children.remove(node.children.size()-1);
            Node sc = node.children.get(node.children.size()-1);
            Node slt = getTail(sc);
            slt.children.add(lc);

        }
    }

    private static Node getTail(Node node) {
        while(node.children.size()==1){
            node=node.children.get(0);
        }
        return node;

    }



    public static Node linearize2(Node node){
        if(node.children.size()==0)return node;
        Node lkt = linearize2(node.children.get(node.children.size()-1));
        while(node.children.size()>1){
            Node last = node.children.remove(node.children.size()-1);
            Node sl = node.children.get(node.children.size()-1);
            Node slkt = linearize2(sl);
            slkt.children.add(last);
        }
        return lkt;
    }

    public static boolean find(Node node, int data) {
        // write your code here
        if(node.data==data)return true;
        for(Node child:node.children){
            boolean fic = find(child,data);
            if(fic)return true;
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data==data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for(Node child:node.children){
            ArrayList<Integer> ptc = nodeToRootPath(child,data);
            if(!ptc.isEmpty()){
                ptc.add(node.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        // write your code here
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return p1.get(i);
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2){
        // write your code here
        ArrayList<Integer> p1 = nodeToRootPath(node,d1);
        ArrayList<Integer> p2 = nodeToRootPath(node,d2);

        int i=p1.size() - 1;
        int j=p2.size() - 1;

        while(i>=0 && j>=0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return i+j;
    }

    public static boolean areSimilar(Node n1, Node n2) {
        // write your code here
        if(n1.children.size() != n2.children.size())return false;
        for(int i=0;i<n1.children.size();i++){
            Node c1=n1.children.get(i);
            Node c2=n2.children.get(i);
            if(!(areSimilar(c2,c2)))return false;
        }
        return true;
    }

    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size())return false;
        for(int i=0,j=n2.children.size()-1;i<n1.children.size() && j>=0;i++,j--){
            Node c1=n1.children.get(i);
            Node c2=n2.children.get(j);
            if(!areMirror(c1,c2))return false;
        }
        return true;
    }

    public static boolean IsSymmetric(Node node) {
        // write your code here
        return areMirror(node,node);

    }







    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int sz = size(root);
        int m = max(root);
        System.out.println(sz);
        // display(root);
    }

}