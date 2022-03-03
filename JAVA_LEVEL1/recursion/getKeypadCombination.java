package PEP.JAVA_LEVEL1.recursion;

import java.util.ArrayList;

public class getKeypadCombination {
    public static void main(String[] args) {
        ArrayList<String> allCombination = getCombination("678");
        System.out.println(allCombination);
    }
    static String[] codes={".;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static ArrayList<String> getCombination(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String rstr = str.substring(1);
        ArrayList<String> rcomb = getCombination(rstr);
        ArrayList<String> finalComb = new ArrayList<>();
//        String chstr = codes[Integer.parseInt(String.valueOf(ch))];
        String chstr = codes[ch-'0'];
        for(int i=0;i<chstr.length();i++){
            for(String rcombstr :rcomb){
                finalComb.add(chstr.charAt(i)+rcombstr);
            }
        }
        return finalComb;
    }

}
