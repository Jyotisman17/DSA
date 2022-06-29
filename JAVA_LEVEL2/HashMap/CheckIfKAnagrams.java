package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class CheckIfKAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int k = sc.nextInt();
        System.out.println(areKAnagrms(str1,str2,k));
    }
    public static boolean areKAnagrms(String str1,String str2,int k){
        if(str1.length()!= str2.length())return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1); // making the hashmap of first string
        }
        for(int i=0;i<str2.length();i++){
            char ch = str2.charAt(i);
            if(map.getOrDefault(ch,0)>0){
                map.put(ch,map.get(ch)-1);
            }
        }
        int count=0;
        for(char ch:map.keySet()){
            count+=map.get(ch); // value having 0 will not change the count value
        }
        if(count>k)return false;
        else return true;
    }
}
