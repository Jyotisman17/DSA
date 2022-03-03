package PEP.JAVA_LEVEL1.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class highestFrequencyChracter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i< string.length();i++){
            char ch = string.charAt(i);
            if(hm.containsKey(ch)){
                int of = hm.get(ch);
                int nf = of+1;
                hm.put(ch,nf);
            }
            else
                hm.put(ch,1);
        }
        char mfc = string.charAt(0);
        for(Character key : hm.keySet()){
            if(hm.get(key)>hm.get(mfc)){
                mfc=key;
            }
        }
        System.out.println("Maximum frequency character in the inputted string is : "+mfc);
        System.out.println("Frequency is "+hm.get(mfc));
        
    }
}
