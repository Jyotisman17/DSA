package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class NoOfValidWords {
    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //write your code here\
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put((char)('a'+i),new ArrayList<>());
        }
        for(String word:words){ // making word's mask and putting it into hashMap of each character
            int mask=0;
            for(char ch : word.toCharArray()){
                int bit=ch-'a';
                mask = mask|(1<<bit);
            }
            HashSet<Character>unique = new HashSet<>();
            for(char ch:word.toCharArray()){
                if(unique.contains(ch))continue;
                unique.add(ch);
                map.get(ch).add(mask);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(String puzzle:puzzles){ // making puzzle's mask
            int pmask=0;
            for(char ch : puzzle.toCharArray()){
                int bit=ch-'a';
                pmask = pmask|(1<<bit);
            }
            char firstChar = puzzle.charAt(0);
            int count=0;
            ArrayList<Integer> wordsToCheck = map.get(firstChar);
            for(int wmask:wordsToCheck){
                if((wmask & pmask) == wmask){
                    count++;
                }
            }
            res.add(count);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for(int i = 0 ; i < m ;i++) {
            puzzles[i] = scn.next();
        }
        ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
        for(int i=0;i<ans.size();i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }
}
