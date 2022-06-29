package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class MaximumDiffOfZeroAndOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(solution(string));
    }

    public static int solution(String string){
        int ans = 0;
        int csum=0;
        for(int i=0;i<string.length();i++){
            int val = 0;
            if(string.charAt(i)=='1')val-=1;
            else if(string.charAt(i)=='0')val+=1;

            if(csum>=0)csum+=val;
            else csum=val;

            if(csum>ans)ans=csum;
        }
        return ans==0?-1:ans;
    }
}
