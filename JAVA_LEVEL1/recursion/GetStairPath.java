package PEP.JAVA_LEVEL1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> paths = getStair(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStair(int n) {
        if(n<=0){
            ArrayList<String> basePath = new ArrayList<>();
            if(n==0)basePath.add("");
            return basePath;
        }
        ArrayList<String> paths1 = getStair(n-1);
        ArrayList<String> paths2 = getStair(n-2);
        ArrayList<String> paths3 = getStair(n-3);

        ArrayList<String> paths = new ArrayList<>();
        for(String path:paths1)
            paths.add("1"+path);
        for(String path:paths2)
            paths.add("2"+path);
        for(String path:paths3)
            paths.add("3"+path);

        return paths;

    }

}
