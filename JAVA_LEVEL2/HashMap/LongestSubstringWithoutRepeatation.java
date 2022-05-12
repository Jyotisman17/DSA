package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static int solution(String str){
        int ans = 0;
        int i=-1;
        int j=-1;

        HashMap<Character,Integer> map = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while(i<str.length()-1){
                f1=true;
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);

                if(map.get(ch)>1){
                    break;
                }else{
                    int len = i-j;
                    if(len>ans)ans=len;
                }
            }

            // realease
            while(j<i){
                f2=true;
                j++;
                char ch = str.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==1){
                    break; // if it get reduced to 1 , then thats the element that got added and made it invalid
                }

            }

            if(!f1 && !f2) break;
        }

        return ans;
    }
}
