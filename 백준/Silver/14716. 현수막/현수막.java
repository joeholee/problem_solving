import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M,N,ans;
    static int[][] board;
    static boolean[][] vis;
    static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};
    static int[] cur;
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        vis = new boolean[M][N];
        for(int r=0; r<M; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0; c<N; c++) board[r][c] = Integer.parseInt(st.nextToken());
        }
        for(int r=0; r<M; r++) {
        	for(int c=0; c<N; c++) {
        		if(board[r][c]==1 && !vis[r][c]) solve(r,c);
        	}
        }
        System.out.println(ans);
    }
    
    static void solve(int r, int c) {
    	q.add(new int[] {r,c});
    	vis[r][c]=true;
    	while(!q.isEmpty()) {
    		cur = q.poll();
    		for(int dir=0; dir<8; dir++) {
    			int nr = cur[0]+dr[dir];
    			int nc = cur[1]+dc[dir];
    			if(nr<0||nr>=M||nc<0||nc>=N) continue;
    			if(vis[nr][nc]||board[nr][nc]==0) continue;
    			vis[nr][nc]=true;
    			q.add(new int[] {nr,nc});
    		}
    	}
    	ans++;
    }
}