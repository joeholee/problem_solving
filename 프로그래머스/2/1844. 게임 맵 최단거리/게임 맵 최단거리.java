import java.util.*;

class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        for(int[] r : dist) Arrays.fill(r,-1);
        bfs(0,0,n,m,maps,dist);
        int answer = dist[n-1][m-1];
        return answer;
    }
    
    void bfs(int r, int c, int n, int m, int[][] maps, int[][] dist) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r,c});
        dist[r][c] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0]==n-1&&cur[1]==m-1) return;
            for(int dir=0; dir<4; dir++) {
                int nr = cur[0]+dr[dir];
                int nc = cur[1]+dc[dir];
                if(nr<0||nr>=n||nc<0||nc>=m) continue;
                if(maps[nr][nc]==0||dist[nr][nc]!=-1) continue;
                dist[nr][nc] = dist[cur[0]][cur[1]]+1;
                q.offer(new int[] {nr,nc});
            }
        }
        return;
    }
}