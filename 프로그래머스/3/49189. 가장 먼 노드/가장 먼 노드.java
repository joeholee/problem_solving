import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, n);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        dist[1]=0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph.get(cur)) {
                if(dist[nxt]>dist[cur]+1) {
                    dist[nxt]=dist[cur]+1;
                    q.offer(nxt);
                }
            }
        }
        Arrays.sort(dist);
        int max = dist[n-1];
        for(int i=n-1; i>=0; i--) {
            if(dist[i]!=max) break;
            answer++;
        }
        return answer;
    }
}

