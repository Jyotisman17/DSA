package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class PalindromicPartitioningWithMinCut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(minPalindromicCut(str));
    }

    public static int minPalindromicCut(String s){
        boolean[][] dp1 = new boolean[s.length()][s.length()];
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j< dp1.length;i++,j++){
                if(g==0){
                    dp1[i][j]=true;
                }else if(g==1){
                    dp1[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp1[i+1][j-1] ){
                        dp1[i][j]=true;
                    }else dp1[i][j]=false;
                }
            }
        }


          // this will have n3 complexity
//        int[][] strg = new int[s.length()][s.length()];
//        for(int g=0;g<s.length();g++){
//            for(int i=0,j=g;j<strg.length;i++,j++){
//                if(g==0){
//                    strg[i][j]=0;
//                }else if(g==1){
//                    strg[i][j]=s.charAt(i)==s.charAt(j)?0:1;
//                }else{
//                    if(dp1[i][j])strg[i][j]=0;
//                    else{
//                        int min = Integer.MAX_VALUE;
//                        for(int k=i;k<j;k++){
//                            int left = strg[i][k];
//                            int right = strg[k+1][j];
//                            if(left+right+1<min){
//                                min=left+right+1;
//                            }
//                        }
//                        strg[i][j]=min;
//                    }
//                }
//            }
//        }
//        return strg[0][s.length()-1];

        int[] strg = new int[s.length()];  // answer container
        strg[0]=0;
        for(int j = 1;j<strg.length;j++){
            if(dp1[0][j]){
                strg[j]=0;
            }else{
                int min = Integer.MAX_VALUE;

                for(int i=j;i>=1;i--){
                    if(dp1[i][j]){
                        if(strg[i-1]<min){
                             min = strg[i-1];
                        }
                    }
                }

                strg[j]=min+1;
            }
        }
        return strg[strg.length-1];
    }
}
