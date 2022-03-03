package PEP.JAVA_LEVEL2.Backtracking;

import java.util.Scanner;

public class maxScore {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int noOfWords = sc.nextInt();
        String[] words = new String[noOfWords];
        for(int i=0;i<words.length;i++){
            words[i]=sc.next();
        }

        int noOfLetters = sc.nextInt();
        char[] letters = new char[noOfLetters];
        for(int i=0;i<letters.length;i++){
            letters[i]=sc.next().charAt(0);
        }

        int[] score = new int[26];
        for(int i=0;i<score.length;i++)score[i]=sc.nextInt();

        if(words==null || words.length==0 || letters==null || letters.length==0 || score==null || score.length==0){
            System.out.println(0);
            return;
        }

        int[] farr = new int[score.length];
        for(char ch:letters){
            farr[ch-'a']++;
        }

        System.out.println(solution(words,farr,score,0));
    }

    public static int solution(String[] words,int[] farr,int[] score,int idx){
        if(idx==words.length)return 0;
        int sno = solution(words,farr,score,idx+1); // not included
        // included the word
        int sword = 0;
        boolean flag = true; // true if yes call can be called
        String word = words[idx];
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(farr[ch-'a']==0){
                flag = false;
            }
            (farr[ch-'a'])--;
            sword += score[ch-'a'];
        }
        int syes = 0;
        if(flag){
            syes= sword + solution(words,farr,score,idx+1);
        }
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            farr[ch-'a']++;
        }
        return Math.max(sno,syes);
    }
}
