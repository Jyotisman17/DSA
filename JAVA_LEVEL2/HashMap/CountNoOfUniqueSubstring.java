package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class CountNoOfUniqueSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
    public static int solution(String str){
        int ans = 0;
        int i =-1;
        int j =-1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(true){
            //acquire
            boolean f1 = false;
            boolean f2 = false;
            while(i<str.length()-1){
                f1=true;
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)>1)break;
                else ans+=i-j;

            }

            while(j<i){
                f2=true;
                j++;
                char ch = str.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==1){
                    ans+=i-j;
                    break;
                }
            }
            if(!f1 && !f2)break;

        }

        return ans;
    }
}
