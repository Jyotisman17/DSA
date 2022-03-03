package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class UTF_8Encodings {
    public static boolean solution(int[] arr) {
        int rbytes = 0;

        for (int val : arr) {
            if (rbytes == 0) {
                if ((val >> 7) == 0b0) { // 1st byte of one length char
                    rbytes = 0;
                } else if ((val >> 5) == 0b110) { // 1st byte of two length char
                    rbytes = 1;
                } else if ((val >> 4) == 0b1110) { // 1st byte of three length char
                    rbytes = 2;

                } else if ((val >> 4) == 0b11110) { // 1st byte of four length char
                    rbytes = 3;
                } else {

                }
            } else {
                if ((val >> 6) == 0b10) {
                    rbytes--;
                } else
                    return false;
            }
        }
        if(rbytes==0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }


}
