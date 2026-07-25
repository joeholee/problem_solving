import java.io.*;
import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int to,weight;
        
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e) {
            return Integer.compare(weight, e.weight);
        }
    }
    static final int INF = 987654321;
    static List<List<Edge>> adj = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int[] f : fares) {
            adj.get(f[0]).add(new Edge(f[1],f[2]));
            adj.get(f[1]).add(new Edge(f[0],f[2]));
        }
        int[] distS = dijkstra(s,n);
        int[] distA = dijkstra(a,n);
        int[] distB = dijkstra(b,n);
        int ret = INF;
        for(int k=1; k<=n; k++) {
            if(distS[k]!=INF && distA[k]!=INF && distB[k]!=INF) {
                ret = Math.min(ret, distS[k]+distA[k]+distB[k]);
            }
        }
        return ret;
    }
    
    int[] dijkstra(int start, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[start]=0;
        pq.offer(new Edge(start,0));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(dist[cur.to]!=cur.weight) continue;
            for(Edge nxt : adj.get(cur.to)) {
                if(dist[nxt.to]>dist[cur.to]+nxt.weight) {
                    dist[nxt.to]=dist[cur.to]+nxt.weight;
                    pq.offer(new Edge(nxt.to,dist[nxt.to]));
                }
            }
        }
        return dist;
    }
}