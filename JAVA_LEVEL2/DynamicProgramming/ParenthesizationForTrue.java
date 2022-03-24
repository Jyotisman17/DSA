package PEP.JAVA_LEVEL2.DynamicProgramming;

import java.util.Scanner;

public class ParenthesizationForTrue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(solution(s1,s2));
    }

    public static int solution(String str1,String str2){
        int n = str1.length();
        int[][] dpt = new int[n][n];
        int[][] dpf = new int[n][n];

        for(int g=0;g<n;g++){
            // gap strategy

            for(int i=0,j=g;j<n;j++,i++){
                if(g==0){
                    char ch = str1.charAt(i);
                    if(ch=='T'){
                        dpt[i][j]=1;
                        dpf[i][j]=0;
                    }else{
                        dpt[i][j]=0;
                        dpf[i][j]=1;
                    }
                }
                else{
                    for(int k=i;k<j;k++){
                        char oprtr = str2.charAt(k);
                        int ltc = dpt[i][k];
                        int rtc = dpt[k+1][j];
                        int lfc = dpf[i][k];
                        int rfc = dpf[k+1][j];
                        if(oprtr=='&'){
                            dpt[i][j]+=ltc*rtc;
                            dpf[i][j]+=ltc*rfc+lfc*rtc+lfc*rfc;
                        }else if(oprtr=='|'){
                            dpt[i][j] += ltc*rtc+ltc*rfc+lfc*rtc;
                            dpf[i][j] += lfc*rfc;
                        }else{
                            dpt[i][j] += ltc*rfc + lfc*rtc;
                            dpf[i][j] += lfc*rfc + ltc*rtc;
                        }
                    }
                }
            }
        }

        return dpt[0][dpt.length-1];
    }
}
