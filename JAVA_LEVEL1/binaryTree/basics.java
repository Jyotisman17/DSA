package PEP.JAVA_LEVEL1.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class basics {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }

    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
    }
    public static void preOrderDisplay(Node node){
        if(node==null)return;
        System.out.print(node.data+" ");
        preOrderDisplay(node.left);
        preOrderDisplay(node.right);
    }
    public static void postOrderDisplay(Node node)
    {
        if(node==null)return;
        postOrderDisplay(node.left);
        postOrderDisplay(node.right);
        System.out.print(node.data+" ");
    }

    public static void inOrder(Node node) {
        if(node==null)return;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public static Node constructTree(Integer[] arr){
        Node node = new Node(arr[0],null,null);
        Pair pair = new Pair(node,1);
        Stack<Pair> st = new Stack<>();
        st.push(pair);
        int idx=0;
        while(!st.isEmpty()){
            Pair top=st.peek();
            if(top.state==1){
                idx++;
                if(arr[idx]!=null){
                    top.node.left= new Node(arr[idx],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                }
                else{
                    top.node.left=null;
                }
                top.state++;
            }else if(top.state==2){
                idx++;
                if(arr[idx]!=null){
                    top.node.right=new Node(arr[idx],null,null);
                    Pair rp=new Pair(top.node.right,1);
                    st.push(rp);
                }else{
                    top.node.right=null;
                }
                top.state++;

            }else{
                st.pop();
            }
        }
        return node;

    }
    public static void display(Node node){
        if(node==null)return;
        String str = "";
        str+=node.left==null?".":node.left.data+"";
        str+=" <- "+node.data+" -> ";
        str+=node.right==null?".":node.right.data+"";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        // write your code here
        if(node==null)return 0;
        int size=0;
        size+=size(node.left);
        size+=size(node.right);
        return size+1;
    }

    public static int sum(Node node) {
        // write your code here
        if(node==null)return 0;
        int sum=node.data;
        sum+=sum(node.left);
        sum+=sum(node.right);
        return sum;
    }
    public static int max(Node node) {
        // write your code here
        if(node==null)return Integer.MIN_VALUE;
        int maxL=max(node.left);
        int maxR=max(node.right);
        int totalMax=Math.max(node.data,Math.max(maxL,maxR));
        return totalMax;

    }

    public static int height(Node node) {
        // write your code here
        if(node==null)return 0;//wrt to edges : -1 , wrt to nodes : 0
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        return Integer.max(leftHeight,rightHeight)+1;
    }

    public static void levelOrder(Node node) {
        // write your code here
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(!q.isEmpty()){
            int count=q.size();
            while(count>0) {
                Node temp = q.remove();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                System.out.print(temp.data + " ");
                count--;
            }
            System.out.println();
        }
    }

    public static void traverse(Node node){
        if(node==null)return;
        System.out.println(node.data+" in PreOrder");
        traverse(node.left);
        System.out.println(node.data+" in inOrder");
        traverse(node.right);
        System.out.println(node.data+" in postOrder");
    }

    public static void iterativePrePostInTraversal(Node node){
        Stack<Pair> st = new Stack<>();
        Pair rtp = new Pair(node,1);
        st.push(rtp);
        String preOrder = "";
        String postOrder = "";
        String inorder = "";
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state==1){ // preorder : s++ , left
                top.state++;
                preOrder+=top.node.data+" ";
                if(top.node.left!=null){
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                }
            }else if(top.state==2){ // inorder : s++ , right
                top.state++;
                inorder+=top.node.data+" ";
                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }
            }else{ //postorder : post , pop
                postOrder+=top.node.data+" ";
                st.pop();
            }
        }
        System.out.println("PreOrder : "+preOrder);
        System.out.println("InOrder : "+inorder);
        System.out.println("PostOrder : "+postOrder);
    }
    static ArrayList<Integer> path;

    static int testing = 10;
    public static boolean find(Node node, int data){
        // write your code here
        if(node==null)return false;
        if(node.data == data){
            path.add(node.data);
            return true;
        }
        boolean checkLeft = find(node.left, data);
        if(checkLeft){
            path.add(node.data);
            return true;
        }
        boolean checkRight = find(node.right,data);
        if(checkRight)return path.add(node.data);
        return false ;

    }
    public static void printKLevelsDown(Node node, int k){
        // write your code here
        if(node==null || k<0){
            return;
        }
        if(k==0) System.out.println(node.data);
        printKLevelsDown(node.left,k-1);
        printKLevelsDown(node.right,k-1);
    }
//-------------------------------------------------------------------------------------
    public static boolean findNodePath(Node node, int data){
        // write your code here
        if(node==null)return false;
        if(node.data == data){
            nodePath.add(node);
            return true;
        }
        boolean checkLeft = findNodePath(node.left, data);
        if(checkLeft){
            nodePath.add(node);
            return true;
        }
        boolean checkRight = findNodePath(node.right,data);
        if(checkRight) {
            nodePath.add(node);
            return true;
        }
        return false;

    }


    static ArrayList<Node> nodePath;
    public static void printKLevelsDownForBlocker(Node node, int k,Node blocker){
        // write your code here
        if(node==null || k<0 || node==blocker){
            return;
        }
        if(k==0) System.out.println(node.data);
        printKLevelsDownForBlocker(node.left,k-1,blocker);
        printKLevelsDownForBlocker(node.right,k-1,blocker);
    }

    public static void printKNodesFar(Node node, int data, int k) {
        // write your code here
        nodePath=new ArrayList<>();  // setting the arrayList
        findNodePath(node,data);     // inserting path as value to the arrayList

        for(int i=0;i<nodePath.size() ;i++){
            printKLevelsDownForBlocker(nodePath.get(i),k-i,i==0?null:nodePath.get(i-1));
        }

    }
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){  //path from root to leaf if the sum of all the element in the path are between the given arguments that is lo and hi
        // write your code here
        if(node==null)return;
        if(node.left==null && node.right==null){
            sum+=node.data;
            path+=node.data;
            if(sum>=lo && sum<=hi)
                System.out.println(path);
            return;

        }
        pathToLeafFromRoot(node.left,path+node.data+" ",sum+node.data,lo,hi);
        pathToLeafFromRoot(node.right,path+node.data+" ",sum+node.data,lo,hi);
    }

    public static Node createLeftCloneTree(Node node){ // will create left clone tree
        // write your code here
        if(node==null)return null;
        Node lcr = createLeftCloneTree(node.left);
        Node rcr = createLeftCloneTree(node.right);
        node.left= new Node(node.data,lcr,null);
        node.right=rcr;
        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node){ //will create right clone tree
        // write your code here
        if(node==null)return null;
        Node lnn = transBackFromLeftClonedTree(node.left.left);
        Node rnn = transBackFromLeftClonedTree(node.right);
        node.left=lnn;
        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent){
        // write your code here
        if(node==null)return;
        if(parent.left==node && parent.right==null)
            System.out.println(node.data);
        else if(parent.right==node && parent.left==null){
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left,node);
        printSingleChildNodes(node.right,node);
    }
    public static Node removeLeaves(Node node){
        // write your code here
        if(node==null)return null;
        if(node.left==null && node.right==null)return null;
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    public static int diameter(Node node){
        if(node==null )return 0;
        int ld=diameter(node.left);//maximum distance between two nodes of left child
        int rd =diameter(node.right);//maximum distance between two nodes of right child
        int f = height(node.left)+height(node.right)+2;
        int diameter = Math.max(f,Math.max(ld,rd));
        return diameter;
    }



    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
//        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node node = constructTree(arr);
        System.out.print("Preorder Traversal of the tree -->> ");
        preOrderDisplay(node);
        System.out.println();
        System.out.print("Postorder Traversal of the tree -->> ");
        postOrderDisplay(node);
        System.out.println();
        System.out.print("Inorder Traversal of the tree -->> ");
        inOrder(node);
        System.out.println("\nDisplaing the whole tree linearly : ");
        display(node);
        System.out.println("Size of the Binary tree is : "+size(node));
        System.out.println("SUM of the Binary tree is : "+sum(node));
        System.out.println("Maximum element of the Binary tree is : " + max(node));
        System.out.println("height element of the Binary tree is : " + height(node));

        System.out.print("\nLevel order traversal of the binary tree is : \n");
        levelOrder(node);

        System.out.println("\n\nFully traversal of the binary tree ");
        traverse(node);


        System.out.println("\n\nDisplaying the content of the binary tree using iterative approach : \n\n");
        iterativePrePostInTraversal(node);

//        path = new ArrayList<>();
//        boolean found = find(node, 62);
//        System.out.println(found);
//
//        System.out.println(path);

        printKNodesFar(node,37,2);

        DiaPair p = diameter2(node);
        System.out.println("Diameter is : "+p.dia);








    }
    // this one is more efficient than the above-mentioned diameter method
    static class DiaPair{
        int ht;
        int dia;
    }
    public static DiaPair diameter2(Node node){
        if(node==null){
            DiaPair basePair = new DiaPair();
            basePair.ht=-1;
            basePair.dia=0;
            return basePair;
        }
        DiaPair left=diameter2(node.left);
        DiaPair right=diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(left.ht,right.ht)+1;

        int factorEitherSide = left.ht+right.ht+2;
        mp.dia=Math.max(factorEitherSide,Math.max(left.dia,right.dia));
        return mp;
    }
}
