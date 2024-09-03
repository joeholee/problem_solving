import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,tmp,ans,max;
    static int[] cur;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] cheese;
    static boolean[][] vis;
    static Queue<int[]> q = new LinkedList<>();
     
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
            vis = new boolean[N][N];
            max = Integer.MIN_VALUE;
            for(int r=0; r<N; r++) {
                String[] input = br.readLine().split(" ");
                for(int c=0; c<N; c++) {
                    cheese[r][c]=Integer.parseInt(input[c]);
                    max = Math.max(max,cheese[r][c]);
                }
            }
            ans=1;
            for(int i=1; i<=max; i++) {
                for(int r=0; r<N; r++) {
                    for(int c=0; c<N; c++) {
                        if(cheese[r][c]<=i) {
                            vis[r][c]=true;
                        }
                    }
                }
                bfs();
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
     
    static void bfs() {
        tmp=0;
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(!vis[r][c]) {
                    q.add(new int[] {r,c});
                    vis[r][c]=true;
                    while(!q.isEmpty()) {
                        cur = q.poll();
                        for(int dir=0; dir<4; dir++) {
                            int nr = cur[0]+dr[dir];
                            int nc = cur[1]+dc[dir];
                            if(nr<0||nr>=N||nc<0||nc>=N) continue;
                            if(vis[nr][nc]) continue;
                            q.add(new int[] {nr,nc});
                            vis[nr][nc]=true;
                        }
                    }
                    tmp++;
                }
            }
        }
        ans = Math.max(ans,tmp);
        for(int r=0; r<N; r++) Arrays.fill(vis[r],false);
    }
}