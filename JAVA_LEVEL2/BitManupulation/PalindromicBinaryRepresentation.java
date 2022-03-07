package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class PalindromicBinaryRepresentation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(NthPalindromicBinary(n));
    }

    public static int NthPalindromicBinary(int n){
        int count = 1;
        int len = 1;
        while (count<n){
            len++;
            int elementsForThisLen = (1<<(len-1)/2);
            count+=elementsForThisLen;
        }
        count-=(1<<(len-1)/2);
        int offset = n-count-1;

        int ans = (1<<(len-1));
        ans|=(offset<<(len/2));

        int valFR = (ans>>(len/2));
        int rev = getReverse(valFR);
        ans|=rev;
        return ans;
    }

    public static int getReverse(int n){
        int rev = 0;
        while(n!=0){
            int lb = (n&1);
            rev|=lb;
            rev<<=1; // left shifting the rev
            n>>=1; // right shifting the orginal number
        }
        rev>>=1;
        return rev;

    }
}
