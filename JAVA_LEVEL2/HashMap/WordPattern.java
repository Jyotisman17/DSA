package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String words = sc.nextLine();
        System.out.println(wordPattern(pattern,words));
    }
    public static boolean wordPattern(String pattern , String str){
        String[] words = str.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Boolean> used = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                if(used.containsKey(words[i])){
                    return false;
                }
                else{
                    used.put(words[i],true);
                    map.put(ch,words[i]);
                }
            }else{
                String mwith = map.get(ch);
                if(!mwith.equals(words[i]))return false;
            }
        }
        return true;
    }
}
