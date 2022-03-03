package PEP.JAVA_LEVEL1.Stack;

import java.util.Scanner;
import java.util.Stack;

public class celebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        
        for(int j=0;j<n;j++)
            for(int k=0;k<n;k++)
                arr[j][k]=sc.nextInt();
        
        findCelebrity(arr);
    }

    private static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i< arr.length;i++){
            st.push(i);
        }
        while (st.size() >= 2) {
            int i=st.pop();
            int j=st.pop();

            if(arr[i][j]==1){
                // if i knows j , then i is not a celebrity
                st.push(j);
            }
            else{
                // if i doesnot knows j , then j is not a celebrity
                st.push(i);
            }
        }
        int pot = st.pop();
        for(int i=0;i<arr.length;i++){
            if(i!=pot){
                if(arr[i][pot]==0 || arr[pot][i]==1){
                    System.out.println("None");
                    return;
                }
            }
        }
        System.out.println("Celebrity is : "+pot);

    }
}
