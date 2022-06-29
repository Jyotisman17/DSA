package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        System.out.println(isIsomorphic(A,B));
    }
    public static boolean isIsomorphic(String s,String t){
        // write your code here
        if(s.length()!=t.length())return false;
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Boolean> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map1.containsKey(ch1)){
                //already present
                if(map1.get(ch1)!=ch2)return false;
            }else{
                if(map2.containsKey(ch2))return false;
                else {
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                }
            }
        }
        return true;
    }
}
