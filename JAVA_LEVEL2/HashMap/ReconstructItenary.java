package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ReconstructItenary {
    // here we will need to find source and destination first
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfPairs = sc.nextInt();
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<noOfPairs;i++){
            String s1 = sc.next();
            String s2 = sc.next();
            map.put(s1,s2);
        }// inserted into a hashmap in pairs

        HashMap<String,Boolean> psrc = new HashMap<>();
        for(String src : map.keySet()){
            String dest = map.get(src);

            psrc.put(dest,false);
            if (!psrc.containsKey(src)) {
                psrc.put(src,true); // putting a true against src
            }
        }

        String src = "";
        for(String pot:psrc.keySet()){
            Boolean value = psrc.get(pot);
            if(value){
                src=pot;
                break;
            }
        }

        while(true){
            if(map.containsKey(src)){
                System.out.print(src+" -> ");
                src=map.get(src);
            }else{
                System.out.print(src+".");
                break;
            }
        }

    }
}
