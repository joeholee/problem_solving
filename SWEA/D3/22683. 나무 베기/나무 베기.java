import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,K,T,ans;
    static char[][] field;
    static boolean[][][] vis; // dirs
    static int[] beg,end,cur;
    static Queue<int[]> q = new LinkedList<>();
    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String args[]) throws Exception
    {
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++)
        {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            field = new char[N][N];
            vis = new boolean[N][N][4];
            for(int r=0; r<N; r++) {
                char[] row = br.readLine().toCharArray();
                for(int c=0; c<N; c++) {
                    field[r][c]=row[c];
                    if(field[r][c]=='X') beg = new int[] {r,c};
                    if(field[r][c]=='Y') end = new int[] {r,c};
                }
            }
            solve();
            sb.append(ans==0 ? -1 : ans).append("\n");
            ans=0;
            q.clear();
        }
        System.out.println(sb);
    }
    
    static void solve() {
        q.add(new int[] {beg[0],beg[1],0,0,0}); // r, c, dir, tree, move
        vis[beg[0]][beg[1]][0]=true; // def=up
        while(!q.isEmpty()) {
        	cur = q.poll();
        	int r=cur[0];
        	int c=cur[1];
        	int dir=cur[2];
        	int tree=cur[3];
        	int move=cur[4];
        	if(r==end[0] && c==end[1]) {
        		ans=move;
        		return;
        	}
        	int nr=r+dr[dir];
        	int nc=c+dc[dir];
        	if(nr>=0 && nr<N && nc>=0 && nc<N && !vis[nr][nc][dir]) {
        		if(field[nr][nc]=='G'||field[nr][nc]=='Y') {
        			vis[nr][nc][dir]=true;
        			q.add(new int[] {nr,nc,dir,tree,move+1});
        		}
        		else if(field[nr][nc]=='T' && tree<K) {
        			vis[nr][nc][dir]=true;
        			q.add(new int[] {nr,nc,dir,tree+1,move+1});
        		}
        	}
        	int left=(dir+3)%4;
        	if(!vis[r][c][left]) {
        		vis[r][c][left]=true;
        		q.add(new int[] {r,c,left,tree,move+1});
        	}
        	int right=(dir+1)%4;
        	if(!vis[r][c][right]) {
        		vis[r][c][right]=true;
        		q.add(new int[] {r,c,right,tree,move+1});
        	}
        }
    }
}