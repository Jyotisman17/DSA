package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.Scanner;

public class printAbbreviation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solve(str);
    }
    public static void solve(String str){
        for(int i=0;i<(1<<str.length());i++){ //for 3 length string , it will run upto 8 and will check each time with the binary bit
            StringBuilder sb = new StringBuilder();
            int count=0;
            for(int j=0;j<str.length();j++){ //iterate over all the words
                int bit = str.length()-1-j;
                if((i & (1<<bit))==0){
                    if(count==0){
                        sb.append(str.charAt(j));
                    }else{
                        sb.append(count);
                        sb.append(str.charAt(j));
                        count=0;
                    }
                }else{
                    count++;
                }
            }
            if(count>0)sb.append(count);
            System.out.println(sb);
        }
    }
}
