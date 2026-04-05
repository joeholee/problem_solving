import java.io.*;
import java.util.*;

class Solution {
    
    static class Edge implements Comparable<Edge> {
        int from,to,weight;
        
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e) {
            return Integer.compare(weight,e.weight);
        }
    }
    
    static int from,to,weight,pick,ret,p[];
    static Edge[] edges;
    
    public int solution(int n, int[][] costs) {
        int e=costs.length;
        p = new int[n+1];
        edges = new Edge[e];
        for(int i=1; i<=n; i++) p[i]=i;
        for(int i=0; i<e; i++) {
            from=costs[i][0];
            to=costs[i][1];
            weight=costs[i][2];
            edges[i] = new Edge(from,to,weight);
        }
        Arrays.sort(edges);
        for(int i=0; i<e; i++) {
            from=edges[i].from;
            to=edges[i].to;
            if(findSet(from)!=findSet(to)) {
                union(from,to);
                pick++;
                ret+=edges[i].weight;
            }
            if(pick==n-1) break;
        }
        return ret;
    }
    
    static int findSet(int x) {
        if(p[x]!=x) p[x]=findSet(p[x]);
        return p[x];
    }
    
    static void union(int a, int b) {
        p[findSet(b)]=p[a];
    }
}