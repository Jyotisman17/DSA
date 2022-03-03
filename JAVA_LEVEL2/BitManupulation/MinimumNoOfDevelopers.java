package PEP.JAVA_LEVEL2.BitManupulation;

import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumNoOfDevelopers {
    static ArrayList<Integer> sol = new ArrayList<>();
    public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int smask) {
        // write your code here
        if(cp==people.length){
            if(smask==((1<<nskills)-1)){
                if(sol.size()==0||onesol.size()<sol.size()){
                    sol = new ArrayList<>(onesol);
                }
            }
            return;
        }
        solution(people,nskills,cp+1,onesol,smask); // for no call recursion
        onesol.add(cp); // pre adding
        solution(people,nskills,cp+1,onesol,(smask | people[cp])); // for yes call recursion
        onesol.remove(onesol.size()-1); // post removing or backtracking
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //
        HashMap<String, Integer> smap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            smap.put(scn.next(), i); // indexing of each domain
        }

        int np = scn.nextInt();
        int[] people = new int[np];
        for (int i = 0; i < np; i++) {
            int personSkills = scn.nextInt();
            for (int j = 0; j < personSkills; j++) {
                String skill = scn.next();
                int snum = smap.get(skill);
                people[i] = people[i] | (1 << snum); // setting on its skill bit
            }
        }

        solution(people, n, 0, new ArrayList<>(), 0);
        System.out.println(sol);

    }
}
