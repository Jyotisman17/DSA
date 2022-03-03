package PEP.JAVA_LEVEL2.Backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class Cryptarithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(); // Inputted first string
        String s2 = sc.nextLine(); // Inputted second string
        String s3 = sc.nextLine(); // Inputted third string

        HashMap<Character,Integer> charIntMap = new HashMap<>();  // HashMap which contains unique characters
        String unique = ""; // unique character string

        for(int i=0;i<s1.length();i++){  // operation on first string to achieve unique characters and fill it in HashMap and unique string
            if(!charIntMap.containsKey(s1.charAt(i))){
                charIntMap.put(s1.charAt(i),-1);
                unique+=s1.charAt(i);
            }
        }

        for(int i=0;i<s2.length();i++){ // operation on second string to achievve unique characters and fill it in HashMap and unique string
            if(!charIntMap.containsKey(s2.charAt(i))){
                charIntMap.put(s2.charAt(i),-1);
                unique+=s2.charAt(i);
            }
        }

        for(int i=0;i<s3.length();i++){ // operation on third string to achieve unique chracters and fill it in HashMap and unique string
            if(!charIntMap.containsKey(s3.charAt(i))){
                charIntMap.put(s3.charAt(i),-1);
                unique+=s3.charAt(i);
            }
        }

        boolean[] usedNumbers = new boolean[10]; // boolean array to check the availability of unique numbers against each unique chracters
        solution(unique,0,charIntMap,usedNumbers,s1,s2,s3);  // calling of solution function
    }
    public static int getNum(String s,HashMap<Character,Integer> charIntMap){
         String num ="";
         for(int i=0;i<s.length();i++){
             num+=charIntMap.get(s.charAt(i));
         }
         return Integer.parseInt(num);
    }
    private static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, String s1, String s2, String s3) {
        if(idx==unique.length()){
            int num1=getNum(s1,charIntMap);
            int num2=getNum(s2,charIntMap);
            int num3=getNum(s3,charIntMap);

            if(num1+num2 == num3){
                for(int i=0;i<26;i++){
                    char ch = (char) ('a'+i);
                    if(charIntMap.containsKey(ch)){
                        System.out.print(ch+"-"+charIntMap.get(ch)+" ");
                    }
                }
                System.out.println();
            }
            return;
        }
        char ch = unique.charAt(idx);
        for(int num =0;num<=9;num++){
            if(usedNumbers[num]==false){
                charIntMap.put(ch,num);
                usedNumbers[num]=true;
                solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
                usedNumbers[num]=false;
                charIntMap.put(ch,-1);
            }
        }
    }


}
