package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ValidAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solution(s1,s2));
    }
    public static boolean solution(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1); // putting all the elements to the hashmap
        }
        // now deleting all the elements from the hashmap
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(!map.containsKey(ch))return false;
            if(map.get(ch)==1)map.remove(ch);
            else map.put(ch,map.get(ch)-1);
        }
        return map.size()==0;
    }
}
