package PEP.JAVA_LEVEL1.Graph;

import java.io.*;
import java.util.*;

public class MultiPath {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        int criteria = Integer.parseInt(br.readLine()); // to find just smaller and larger than the given input
        int k = Integer.parseInt(br.readLine()); // to find the kth largest weighted path

        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        assert pq.peek() != null;
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    }



    static String spath; // smallest path
    static Integer spathwt = Integer.MAX_VALUE; // smallest path weight
    static String lpath; // largest path
    static Integer lpathwt = Integer.MIN_VALUE; // largest path weight
    static String cpath; // ceil path -- just greater than the input criteria
    static Integer cpathwt = Integer.MAX_VALUE; // ceil path weight
    static String fpath; // floor path
    static Integer fpathwt = Integer.MIN_VALUE; // floor path weight
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if(src==dest){
            if(wsf<spathwt){
                spathwt=wsf;
                spath=psf;
            }
            if(wsf>lpathwt){
                lpathwt=wsf;
                lpath=psf;
            }

            if(wsf>fpathwt && wsf<criteria){
                fpathwt=wsf;
                fpath=psf;
            }

            if(wsf<cpathwt && wsf>criteria){
                cpathwt=wsf;
                cpath=psf;
            }
            if(pq.size()<k){
                pq.add(new Pair(wsf,psf));
            }else{
                if(wsf>pq.peek().wsf){
                    pq.remove();
                    pq.add(new Pair(wsf,psf));
                }
            }
            return;
        }
        visited[src]=true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr]==false){
                multisolver(graph,edge.nbr,dest,visited,criteria,k,psf+ edge.nbr,wsf+edge.wt);
            }
        }
        visited[src]=false;
    }
}