package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class ReduceTo1inMin {
    public static int solution(long n){
        int res = 0;
        while(n!=1){
            if(n%2==0){
                n=n/2;
            }else if(n==3){// special case
                n = n-1;
            }else if((n & 3)==1){
                n = n-1;
            }else if((n & 3)==3){
                n = n+1;
            }
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
