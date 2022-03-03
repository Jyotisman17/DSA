package PEP.JAVA_LEVEL1.BST;

public class basics {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if(node==null)return;
        String str = "";
        str+=node.left==null?".":node.left.data+" ";
        str+=" <- "+node.data+" -> ";
        str+=node.right==null?".":node.right.data+" ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static Node construct(int[] arr, int lo, int hi) {
        if(lo>hi){
            return null; // it will work to make leaf node
        }
        int mid = (lo + hi) / 2;
        int data = arr[mid];
        Node lc = construct(arr, lo, mid - 1);
        Node rc = construct(arr, mid + 1, hi);

        Node node = new Node(data, lc, rc);
        return node;

    }

    public static int sum(Node node) {
        if(node==null)return 0;
        int leftSum = sum(node.left);
        int rightSum =sum(node.right);

        int totalSum = leftSum+rightSum+node.data;
        return totalSum;
    }

    public static int max(Node node) {
        if(node.right!=null)return max(node.right);
        else return node.data;
    }

    public static int min(Node node) {
        if(node.left!=null) return min(node.left);
        else return node.data;
    }

    public static boolean find(Node node, int k) {
        if(node==null)return false;
        if(k>node.data)return find(node.right,k);
        else if(k<node.data)return find(node.left,k);
        else return true;

    }

    public static Node add(Node node, int data) {
        if(node==null){
            return new Node(data,null,null);
        }
        if(data>node.data)
            node.left = add(node.right,data);
        else if(data<node.data)
            node.right = add(node.left,data);


        return node;
    }

    public static Node remove(Node node , int data){
        if(node==null)return null;
        if(data>node.data)node.right=remove(node.right,data);
        else if(data<node.data)node.left = remove(node.left,data);
        else{
            if(node.left!=null && node.right!=null){
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node,lmax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if(node.right !=null){
                return node.right;
            } else{
                return null;
            }
        }
        return node;
    }

    public static int size(Node node){
        if(node==null)return 0;
        int ls = size(node.left);
        int rs = size(node.right);
        int totalSize = ls+rs+1;
        return totalSize;
    }
    public static void main(String[] args) {
        int[] arr={12,24,37,40,56,66,76}; // binary search tree can only be made from a sorted input
        // we can give the input from the user too
        Node root = construct(arr,0,arr.length-1);
        display(root);
        int maxElement = max(root);
        System.out.println("Max value : "+maxElement);
        boolean findResult = find(root,66);
        System.out.println("find : "+findResult);
    }
}
