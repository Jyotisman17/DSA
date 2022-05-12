package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithKUniqueCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        System.out.println(solution(str,k));
    }
    public static int solution(String str,int k){
        int ans = 0;
        int i=-1,j=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(true){
            boolean f1 = false,f2=false;
            while(i<str.length()-1){
                f1=true;
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()<k){
                    continue;
                }else if(map.size()==k){
                    int len = i-j;// it will give the length of the potential answer
                    if(len>ans)ans=len;
                }else {
                    break;
                }

            }

            while(j<i){
                f2=true;
                j++;
                char ch = str.charAt(j);
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);// reduce the frequency by 1
                }

                if(map.size()>k){
                    continue;
                }else if(map.size()==k){
                    int len = i-j;// it will give the length of the potential answer
                    if(len>ans)ans=len;
                    break;
                }
            }

            if(!f1&&!f2)break; // if both the while condition are invalid then no need to continue the main whhile loop

        }

        return ans;
    }
 }
