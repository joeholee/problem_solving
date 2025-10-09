class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] vis = new boolean[dungeons.length];
        answer = Math.max(answer, dfs(k,0,dungeons,vis));
        return answer;
    }
    
    int dfs(int cur, int clear, int[][] dungeons, boolean[] vis) {
        int maxClear=clear;
        for(int i=0; i<dungeons.length; i++) {
            if(!vis[i]) {
                if(cur<dungeons[i][0]) continue;
                else {
                    vis[i]=true;
                    maxClear = Math.max(maxClear, dfs(cur-dungeons[i][1],clear+1,dungeons,vis));
                    vis[i]=false;
                }
            }
        }
        return maxClear;
    }
}