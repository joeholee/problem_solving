class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public int[][] solution(int n) {
        int r = 0, c = 0, dir = 0, num = 1;
        int[][] answer = new int[n][n];
        for(int i=1; i<=n*n; i++) {
            answer[r][c] = num++;
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            if(nr<0||nr>=n||nc<0||nc>=n||answer[nr][nc]!=0) dir = (dir+1)%4;
            r+=dr[dir];
            c+=dc[dir];
        }
        return answer;
    }
}