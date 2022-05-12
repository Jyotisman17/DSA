package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class MinWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solution(s1, s2));
    }

    public static String solution(String s1, String s2){
        String ans = "";
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int mct = 0;
        int dmct = s2.length();

        HashMap<Character,Integer> map1 = new HashMap<>();
        int i=-1,j=-1;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while(i<s1.length()-1 && mct<dmct){
                i++;
                char ch = s1.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0))mct++;
                f1=true;
            }
            // collect ans and release
            while(j<i && mct == dmct){
                String pans = s1.substring(j+1,i+1);
                if(ans.length()==0 || pans.length()<ans.length())ans=pans;
                j++;
                char ch = s1.charAt(j);// release
                if(map1.get(ch)==1) map1.remove(ch);
                else map1.put(ch,map1.get(ch)-1);

                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0)){
                    mct--;
                }
                f2 = true;

            }

            if(f1==false && f1==false)break;
        }
        return ans;
    }
}
