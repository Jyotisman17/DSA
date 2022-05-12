package PEP.JAVA_LEVEL2.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class NoOfEmpUnderEachEmp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String,String> map = new HashMap<String,String>(); // input for every pair emp and manager
        for(int i=0;i<n;i++)map.put(sc.next(),sc.next());
        findCount(map);
    }

    public static void findCount(HashMap<String,String> map){ // map is the pair of emp and manager
        HashMap<String, HashSet<String>> tree = new HashMap<>(); // generic tree
        String ceo = "";

        for(String emp : map.keySet()){
            String man = map.get(emp); // get the manager
            if(man.equals(emp)){
                ceo = man;
            }else{
                if(tree.containsKey(man)){
                    HashSet<String> emps = tree.get(man);
                    emps.add(emp);

                }else{
                    HashSet<String> emps = new HashSet<>();
                    emps.add(emp);
                    tree.put(man,emps);
                }
            }
        }
        HashMap<String,Integer> result = new HashMap<>();
        getSize(tree,ceo,result);

        for(String emp:result.keySet()){
            System.out.println(emp+" "+result.get(emp));
        }
    }

    public static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> result){
        if(!tree.containsKey(man)){
            result.put(man,0);
            return 1;
        }
        int size = 0;
        for(String emp:tree.get(man)){
            int cs = getSize(tree,emp,result);
            size+=cs;
        }
        result.put(man,size);
        return size+1;
    }


}
