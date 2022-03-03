package PEP.JAVA_LEVEL1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<String> paths = getMazeWithJumps(1,1,n,m);
        System.out.println(paths);
    }

    public static ArrayList<String> getMaze(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> basePath = new ArrayList<>();
            basePath.add("");
            return basePath;
        }

        ArrayList<String> hPath = new ArrayList<>();
        ArrayList<String> vPath = new ArrayList<>();
        if(sc<dc) {
            hPath = getMaze(sr,sc+1,dr,dc);
        }
        if(sr<dr)
            vPath = getMaze(sr + 1, sc, dr, dc);

        ArrayList<String> path = new ArrayList<>();
        for(String str : hPath)
            path.add("h"+str);
        for(String str :vPath)
            path.add("v"+str);


        return path;

    }

    public static ArrayList<String> getMazeWithJumps(int sr,int sc,int dr,int dc){
        if(sr==dr && sc == dc){
            ArrayList<String> basePath = new ArrayList<>();
            basePath.add("");
            return basePath;
        }
        ArrayList<String> path = new ArrayList<>();
       //horizontal moves
        for(int ms=1;ms<=dc-sc;ms++){
            ArrayList<String> hPaths = getMazeWithJumps(sr,sc+ms,dr,dc);
            for(String hpath:hPaths){
                path.add("h"+ms+hpath);
            }
        }
        // vertical moves
        for(int ms=1;ms<=dr-sr;ms++){
            ArrayList<String> vPaths = getMazeWithJumps(sr+ms,sc,dr,dc);
            for(String vpath:vPaths){
                path.add("v"+ms+vpath);
            }
        }

        //diagonal moves
        for(int ms=1;ms<=dr-sr && ms<=dc-sc;ms++){
            ArrayList<String>dPaths = getMazeWithJumps(sr+ms,sc+ms,dr,dc);
            for(String dpath:dPaths)
                path.add("d"+ms+dpath);
        }
        return path;




    }


}
