package PEP.JAVA_LEVEL2.Backtracking;

import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n,k));
    }

    public static int solution(int n,int k){  // 0 to n-1 , we will kill kth people
        if(n==1)return 0;
        int x=solution(n-1,k); // survival for n minus 1 people
        int y=(x+k)%n;
        return y;
    }
}
