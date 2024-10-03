import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,Q,C,dir;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] field;
	static int[] beg,end,cur;
	static char[] cmd;
	
	public static void main(String args[]) throws Exception
	{
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++)
		{
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			field = new char[N][N];
			for(int r=0; r<N; r++) {
				char[] row = br.readLine().toCharArray();
				for(int c=0; c<N; c++) {
					field[r][c]=row[c];
					if(field[r][c]=='X') beg = new int[] {r,c};
					if(field[r][c]=='Y') end = new int[] {r,c};
				}
			}
			Q = Integer.parseInt(br.readLine());
			for(int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine());
				C = Integer.parseInt(st.nextToken());
				cmd = st.nextToken().toCharArray();
				solve();
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void solve() {
		cur = new int[] {beg[0],beg[1]};
		dir=0;
		for(int i=0; i<C; i++) {
			char now = cmd[i];
			switch(now) {
			case 'A':
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=N) continue;
				if(field[nr][nc]=='T') continue;
				cur[0]=nr;
				cur[1]=nc;
				break;
			case 'L':
				dir = (dir+3)%4;
				break;
			case 'R':
				dir = (dir+1)%4;
				break;
			}
		}
		sb.append(cur[0]==end[0]&&cur[1]==end[1] ? 1 : 0).append(" ");
	}
}