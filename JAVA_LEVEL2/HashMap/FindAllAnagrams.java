package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class FindAllAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        findAnagrams(s,p);
    }
    public static void findAnagrams(String s , String p){
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);//making the frequency map of pattern
        }
        for(int i=0;i<p.length();i++){
            char ch = s.charAt(i);
            smap.put(ch,smap.getOrDefault(ch,0)+1);// making the frequency map of source of length as of pattern
        }
        int i = p.length();
        int count = 0;
        StringBuilder ans = new StringBuilder();
        while(i<s.length()){
            if(compare(pmap,smap)){
                count++;
                ans.append(i-p.length()).append(" ");
            }
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0)+1);// for acquiring next element
            char chr = s.charAt(i-p.length());
            if(smap.get(chr)==1)smap.remove(chr);
            else smap.put(chr,smap.get(chr)-1);
            i++;

        }
        if(compare(pmap,smap)){// need to compare once again after last remove
            count++;
            ans.append(i-p.length()).append(" ");
        }

        System.out.println(count);
        System.out.println(ans);
    }
    public static boolean compare(HashMap<Character,Integer> pmap , HashMap<Character,Integer> smap){
        for(char sch :smap.keySet()){
            if(pmap.getOrDefault(sch,0)!= smap.get(sch)){
                return false;
            }
        }
        return true;
    }
}
