package PEP.JAVA_LEVEL2.HashMap;
import java.util.*;

public class CountSubstringWithKUniqueChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        System.out.println(solution(str,k));
    }

    public static int solution(String str,int k){
        int ans = 0;
        HashMap<Character,Integer> mapb = new HashMap<>();
        HashMap<Character,Integer> maps = new HashMap<>();
        int is = -1,ib=-1,j=-1;
        while(true){
            boolean f1=false,f2=false,f3=false;
            while(ib<str.length()-1){
                f1=true;
                ib++;
                char ch = str.charAt(ib);
                mapb.put(ch,mapb.getOrDefault(ch,0)+1);
                if(mapb.size()>k){
                    removeInMap(mapb,ch);
                    ib--;
                    break;
                }
            }

            while(is<ib){
                f2=true;
                is++;
                char ch = str.charAt(is);
                maps.put(ch,maps.getOrDefault(ch,0)+1);
                if(maps.size()==k){
                    removeInMap(maps,ch);
                    is--;
                    break;
                }
            }
            while(j<is){
                f3=true;
                if(mapb.size()==k && maps.size()==(k-1)){
                    ans+=ib-is;
                }
                j++;
                char ch =  str.charAt(j);
                removeInMap(maps,ch);
                removeInMap(mapb,ch);

                if(maps.size()<k-1|| mapb.size()<k){
                    break;
                }
            }

            if(!f1&&!f2&&!f3)break;
        }
        return ans;
    }

    public static void removeInMap(HashMap<Character,Integer> map,char ch){
        if(map.get(ch)==1)map.remove(ch);
        else map.put(ch,map.get(ch)-1);
    }



}
