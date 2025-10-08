import java.util.*;

class Solution {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] group = new int[n][m];
        Map<Integer,Integer> map = new HashMap<>();
        int id = 1;
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(land[r][c]==1&&!vis[r][c]) {
                    int size = bfs(r,c,land,group,vis,id);
                    map.put(id,size);
                    id++;
                }
            }
        }
        int answer = 0;
        for(int c=0; c<m; c++) {
            int sum=0;
            Set<Integer> s = new HashSet<>();
            for(int r=0; r<n; r++) {
                if(group[r][c]>0) s.add(group[r][c]);
            }
            for(int i : s) sum+=map.get(i);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    int bfs(int r, int c, int[][] land, int[][] group, boolean[][] vis, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        vis[r][c]=true;
        q.offer(new int[] {r,c});
        group[r][c]=id;
        int tmp=1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0; dir<4; dir++) {
                int nr = cur[0]+dr[dir];
                int nc = cur[1]+dc[dir];
                if(nr<0||nr>=land.length||nc<0||nc>=land[0].length) continue;
                if(vis[nr][nc]||land[nr][nc]==0) continue;
                vis[nr][nc]=true;
                q.offer(new int[] {nr,nc});
                group[nr][nc]=id;
                tmp++;
            }
        }
        return tmp;
    }
}