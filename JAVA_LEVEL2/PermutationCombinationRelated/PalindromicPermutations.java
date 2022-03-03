package PEP.JAVA_LEVEL2.PermutationCombinationRelated;

import java.util.HashMap;
import java.util.Scanner;

public class PalindromicPermutations {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            fmap.put(ch,fmap.getOrDefault(ch,0)+1);
        }
        Character odd = null;
        int odds = 0;
        int len = 0;

        for(char ch:fmap.keySet()){ // interate over the keyset of the hashmap
            int freq=fmap.get(ch);  // find the frequency of each key
            if(freq%2==1){ // check for whether it is odd or not
                odd=ch; //assign to odd to insert in between
                odds++; // to check whether more than one odd present
            }
            fmap.put(ch,freq/2); // putting the half frequency
            len+=freq/2; // increasing the len accordingly

        }
        if(odds>1) {
            System.out.println(-1);
            return;
        }

        generatepp(1,len,fmap,odd,"");
    }
    public static void generatepp(int cs,int ts,HashMap<Character,Integer> fmap,Character odd,String asf ){

        if(cs>ts){
            String rev = "";
            for(int i=asf.length()-1;i>=0;i--){
                rev+=asf.charAt(i);
            }
            String res=asf;
            if(odd!=null)res+=odd;
            res+=rev;

            System.out.println(res);
            return;
        }
        for(char ch : fmap.keySet()){
            int freq = fmap.get(ch);
            if(freq>0) {
                fmap.put(ch, freq - 1);
                generatepp(cs + 1, ts, fmap, odd, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }
}
