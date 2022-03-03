package PEP.JAVA_LEVEL2.PermutationCombinationRelated;

import java.io.*;
import java.util.*;

public class PermutationOfAStringwithItemsOnLevel {

    public static void generateWords(int cc, String str, Character[] spots,
                                     HashMap<Character, Integer> lastOccurence) {
        // write your code here
        if(cc>=str.length()){
            for(char val:spots) System.out.print(val);
            System.out.println();
            return;
        }
        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch); // pos or -1
        for(int i=lo+1;i<spots.length;i++){
            if(spots[i]==null){
                spots[i]=ch;
                lastOccurence.put(ch,i);
                generateWords(cc+1,str,spots,lastOccurence);
                lastOccurence.put(ch,lo);
                spots[i]=null;
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // inputted string

        Character[] spots = new Character[str.length()];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for(char ch: str.toCharArray()){
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, spots, lastOccurence);
    }

}