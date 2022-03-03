package PEP.JAVA_LEVEL1.LinkedList;

import java.io.*;
import java.util.Scanner;

public class AllLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;

                temp.next = node;
                size++;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }

        private Node getNodeInfo(int idx){
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }
        public void reverseDI() { // reverse digit iterative
            // write your code here
            if(size==0 || size==1)return;
            int li = 0;
            int ri = size-1;
            while(li<ri){
                Node left = getNodeInfo(li);
                Node right = getNodeInfo(ri);

               int temp = left.data;
               left.data = right.data;
               right.data = temp;


                li++;
                ri--;
            }

        }
        public int kthFromLast(int k){  // with a single traversal using iterative approach
            // write your code here
            Node s = head;
            Node f = head;

            for(int i=0;i<k;i++){
                f=f.next;
            }
            while(f!=tail){
                f=f.next;
                s=s.next;
            }
            return s.data;
        }
        public int mid(){ // with a single traversal approach
            //we will use two pointer approach from a single side

            Node s = head;
            Node f = head;

            while(f.next!=null && f.next.next!=null){
                s=s.next;
                f=f.next.next;
            }
            return s.data;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            // write your code here

            Node one = l1.head;
            Node two = l2.head;

            LinkedList res = new LinkedList();
            while(one!=null & two!=null){
                if(one.data<two.data){
                    res.addLast(one.data);
                    one=one.next;
                }
                else{
                    res.addLast(two.data);
                    two=two.next;
                }
            }
            while(one!=null){
                res.addLast(one.data);
                one = one.next;
            }
            while(two!=null){
                res.addLast(two.data);
                two = two.next;

            }

            return res;
        }

        public static Node midNode(Node head, Node tail) {
            Node f = head;
            Node s = head;

            while (f != tail && f.next != tail) {
                f = f.next.next;
                s = s.next;
            }
            return s;
        }
        public static LinkedList mergeSort(Node head, Node tail){
            // write your code here
            if(head==tail){
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }
            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head,mid);
            LinkedList ssh  = mergeSort(mid.next,tail);
            LinkedList c1 = LinkedList.mergeTwoSortedLists(fsh,ssh);
            return c1;




        }
        public void removeDuplicates(){
            // write your code here
            LinkedList res = new LinkedList();
            while(this.size()>0){
                int val = this.getFirst();
                this.removeFirst();

                if(res.size()==0||res.tail.data!=val){
                    res.addLast(val);
                }
            }
            this.head=res.head;
            this.tail=res.tail;
            this.size=res.size;
        }

        public void oddEven(){
            // write your code here
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while(this.size > 0 ){
                int val = this.getFirst();
                this.removeFirst();
                if(val%2==0)
                    even.addLast(val);
                else odd.addLast(val);

            }
            if(odd.size()>0 && even.size()>0) {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            }else if(odd.size > 0 ){
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
            else if(even.size() > 0 ){
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }
        public void kReverse(int k) {
            // write your code here
            LinkedList prev = null;
            while(this.size>0){
                LinkedList curr = new LinkedList();
                if(this.size >=k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }else {
                    int originalSize = this.size;
                    for (int i = 0; i < originalSize; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }
                if(prev==null){
                    prev = curr;
                }else{
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }

            }
            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }

        private void displayReverseHelper(Node node){
            // write your code here
            if(node==null){
                return;
            }
            displayReverseHelper(node.next);
            System.out.println(node.data+" ");
        }

        public void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }

        public void reversePI(){
            Node prev = null;
            Node curr = head;
            while(curr!=null){
                Node next = curr.next;
                curr.next=prev;

                prev = curr;
                curr = next;


            }
            Node temp = head;
            head = tail;
            tail = temp;
        }

        private void reversePRHelper(Node node){
            // write your code here
            if(node==null)return;
            reversePRHelper(node.next);
            if(node!=tail){
                node.next.next = node;
            }
        }

        public void reversePR(){
            // write your code here
            reversePRHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public void reverseDRHelper(Node right,int floor){
            if(right == null) return ;
            reverseDRHelper(right.next,floor+1);

            if(floor>=size/2) {

                int temp = right.data;
                right.data = rleft.data;
                rleft.data = temp;

                rleft = rleft.next;
            }
        }
        Node rleft;
        public void reverseDR(){
            rleft = head;
            reverseDRHelper(head,0);
        }

        private boolean IsPalindromeHelper(Node right){
            if(right==null)return true;
            boolean rres = IsPalindromeHelper(right.next);
            if(rres==false)
                return false;
            else if(right.data != pleft.data)
                return false;
            else {
                pleft=pleft.next;
                return true;
            }
        }
        Node pleft;
        public boolean IsPalindrome() {
            // write your code here
            pleft = head;
            return IsPalindromeHelper(head);
        }

        private void foldHelper(Node right,int floor) {
            if(right == null) return;
            foldHelper(right.next, floor + 1);

            if(floor>size/2) {
                Node temp = fleft.next;
                fleft.next = right;
                right.next = temp;
                fleft = temp;
            }else if(floor==size/2){
                tail = right;
                tail.next = null;
            }
        }
        Node fleft;
        public void fold() {
            // write your code here
            fleft=head;
            foldHelper(head,0);
        }

        public static int addListHelper(Node one , int pv1,Node two,int pv2,LinkedList res){
            if(one == null && two == null){
                return 0;
            }

            int data = 0;
            if(pv1>pv2){
                int oc = addListHelper(one.next,pv1-1,two,pv2,res);
                data = one.data + oc;
            }else if(pv1<pv2){
                int oc = addListHelper(one,pv1,two.next,pv2-1,res);
                data = two.data + oc;

            }else{
                int oc = addListHelper(one.next,pv1-1,two.next,pv2-1,res);
                data = one.data + two.data + oc;
            }
            int nd = data%10;
            int nc = data/10;
            res.addFirst(nd);
            return nc;
        }
        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            // write your code here
            LinkedList res = new LinkedList();

            int oc = addListHelper(one.head,one.size,two.head,two.size,res);
            if(oc>0){
                res.addFirst(oc);
            }
            return res;
        }

        public static int findIntersection(LinkedList one, LinkedList two){
            // write your code here
            Node t1 = one.head;
            Node t2 = two.head;

            int delta = Math.abs(one.size - two.size);
            if(one.size > two.size){
                for(int i=0;i<delta;i++){
                    t1 = t1.next;
                }
            }else{
                for(int i=0;i<delta;i++)
                    t2=t2.next;
            }

            while(t1!=t2){
                t1=t1.next;
                t2=t2.next;
            }
            return t2.data;
        }

    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to use the basics of linked list ");
        System.out.println("Press 2 to merge two linked list ");
        System.out.println("Press 3 to sort a linked list using merge sort ");
        int n = sc.nextInt();
        if (n == 1) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            LinkedList list = new LinkedList();

            String str = br.readLine();
            while (!str.equals("quit")) {
                if (str.startsWith("addLast")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    list.addLast(val);
                    System.out.println("Value added !");
                } else if (str.startsWith("size")) {
                    System.out.println(list.size());
                } else if (str.startsWith("display")) {
                    list.display();
                } else if (str.startsWith("removeFirst")) {
                    list.removeFirst();
                } else if (str.startsWith("getFirst")) {
                    int val = list.getFirst();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("getLast")) {
                    int val = list.getLast();
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("getAt")) {
                    int idx = Integer.parseInt(str.split(" ")[1]);
                    int val = list.getAt(idx);
                    if (val != -1) {
                        System.out.println(val);
                    }
                } else if (str.startsWith("addFirst")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    list.addFirst(val);
                } else if (str.startsWith("addAt")) {
                    int idx = Integer.parseInt(str.split(" ")[1]);
                    int val = Integer.parseInt(str.split(" ")[2]);
                    list.addAt(idx, val);
                } else if (str.startsWith("removeLast")) {
                    list.removeLast();
                } else if (str.startsWith("removeAt")) {
                    int idx = Integer.parseInt(str.split(" ")[1]);
                    list.removeAt(idx);
                } else if (str.startsWith("reverseDI")) {
                    list.reverseDI();
                } else if (str.startsWith("kthFromEnd")) {
                    int idx = Integer.parseInt(str.split(" ")[1]);
                    System.out.println(list.kthFromLast(idx));
                } else if (str.startsWith("mid")) {
                    System.out.println(list.mid());
                }
                else if(str.startsWith("removeDuplicates")){
                    list.removeDuplicates();
                }
                else if(str.startsWith("oddEven")){
                    list.oddEven();
                }else if(str.startsWith("KReverse")){
                    System.out.println("Enter the value of k");
                    int k = Integer.parseInt(br.readLine());
                    list.kReverse(k);
                }
                else if(str.startsWith("displayReverse")){
                    list.displayReverse();
                }
                else if(str.startsWith("reverse using pointer ")){
                    list.reversePR();
                }
                else if(str.startsWith("reverseDR")){
                    list.reverseDR();
                }
                str = br.readLine();
            }
        }else if(n==2){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n1 = Integer.parseInt(br.readLine());
            LinkedList l1 = new LinkedList();
            String[] values1 = br.readLine().split(" ");
            for (int i = 0; i < n1; i++) {
                int d = Integer.parseInt(values1[i]);
                l1.addLast(d);
            }

            int n2 = Integer.parseInt(br.readLine());
            LinkedList l2 = new LinkedList();
            String[] values2 = br.readLine().split(" ");
            for (int i = 0; i < n2; i++) {
                int d = Integer.parseInt(values2[i]);
                l2.addLast(d);
            }

            LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
            merged.display();
            l1.display();
            l2.display();
        }
        else if(n==3) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n1 = Integer.parseInt(br.readLine());
            LinkedList l1 = new LinkedList();
            String[] values1 = br.readLine().split(" ");
            for (int i = 0; i < n1; i++) {
                int d = Integer.parseInt(values1[i]);
                l1.addLast(d);
            }

            LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
            sorted.display();
            l1.display();
        }
        else{
            System.out.println("Please enter a valid input next time , Thank you for using this program ");
            System.out.println("To use again , press the run the program again ");
        }

    }


}