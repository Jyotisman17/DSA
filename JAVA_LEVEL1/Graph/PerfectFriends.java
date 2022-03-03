package PEP.JAVA_LEVEL1.Graph;
import java.io.*;
import java.util.*;

public class PerfectFriends {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here
        ArrayList<Edge>[] graph =new ArrayList[n];
        for(int v=0;v<n;v++)graph[v]=new ArrayList<>();
        for(int e=0;e<k;e++){
            String line = br.readLine();
            int v1= Integer.parseInt(line.split(" ")[0]);
            int v2= Integer.parseInt(line.split(" ")[1]);

            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps= new ArrayList<>();
        for(int v=0;v<n;v++){
            if(visited[v]==false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndCreateComp(graph,v,comp,visited);
                comps.add(comp);
            }
        }
        int pairs = 0;
        for(int i=0;i< comps.size()-1;i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }

        }
        System.out.println(pairs);

    }

    public static void drawTreeAndCreateComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        visited[src]=true;
        comp.add(src);
        for(Edge edge: graph[src]){
            if(visited[edge.nbr]==false){
                drawTreeAndCreateComp(graph,edge.nbr,comp,visited);
            }
        }
    }
    public static class Edge{
        int v;
        int nbr;

        Edge(int v , int nbr){
            this.v = v;
            this.nbr = nbr;
        }
    }

}