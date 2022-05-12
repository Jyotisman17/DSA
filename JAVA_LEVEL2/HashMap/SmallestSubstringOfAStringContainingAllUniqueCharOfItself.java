package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SmallestSubstringOfAStringContainingAllUniqueCharOfItself { // Min window substring - 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static int solution(String str){
        int len = Integer.MAX_VALUE;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            set.add(ch);
        } // hashset size will let us know the number of set characters

        int i = -1;
        int j = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            //acquire till it is invalid map.size()<set.size();
            while(i<str.length()-1 && map.size()<set.size()){
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                flag1=true;
            }

            // collect and release
            while(j<i && map.size()==set.size()){
                int plen = i - j;
                if(plen < len)len=plen;
                j++;
                // release
                char ch = str.charAt(j);
                if(map.get(ch)==1)map.remove(ch);
                else map.put(ch,map.get(ch)-1);
                flag2=true;
            }

            if(flag1==false && flag2==false)break;
        }



        return len;
    }
}
