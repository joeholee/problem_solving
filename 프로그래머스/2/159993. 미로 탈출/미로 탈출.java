import java.util.*;

class Solution {
    static final int[] dr = {-1,0,1,0};
    static final int[] dc = {0,1,0,-1};
    static int n,m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char ch = maps[i].charAt(j);
                if(ch=='S') { start[0]=i; start[1]=j; }
                if(ch=='L') { lever[0]=i; lever[1]=j; }
                if(ch=='E') { end[0]=i; end[1]=j; }
            }
        }
        int stol = bfs(maps, start, lever);
        int ltoe = bfs(maps, lever, end);
        if(stol==-1||ltoe==-1) return -1;
        return stol+ltoe;
    }
    
    int bfs(String[] maps, int[] start, int[] end) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for(int[] r : dist) Arrays.fill(r,-1);
        q.offer(start);
        dist[start[0]][start[1]]=0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0]==end[0]&&cur[1]==end[1]) return dist[cur[0]][cur[1]];
            for(int dir=0; dir<4; dir++) {
                int nr=cur[0]+dr[dir];
                int nc=cur[1]+dc[dir];
                if(nr<0||nr>=n||nc<0||nc>=m) continue;
                if(maps[nr].charAt(nc)=='X') continue;
                if(dist[nr][nc]!=-1) continue;
                dist[nr][nc] = dist[cur[0]][cur[1]]+1;
                q.offer(new int[] {nr,nc});
            }
        }
        return -1;
    }
}