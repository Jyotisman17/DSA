package PEP.JAVA_LEVEL1.HashMap;

import java.util.HashMap;
import java.util.Set;

public class basics {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Jyotisman",15);
        hashMap.put("Jyotisman1",15);
        hashMap.put("Jyotisman2",15);
        hashMap.put("Jyotisman3",15);
        hashMap.put("Jyotisman4",15);
        hashMap.put("Jyotisman5",15);


        System.out.println(hashMap);
        Set<String> set = hashMap.keySet();
        for(String string :set){
            int val = hashMap.get(string);
            System.out.println(string+" "+val);
        }
    }

}
