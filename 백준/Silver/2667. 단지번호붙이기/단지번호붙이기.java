import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,cnt;
	static int[] cur;
	static char[][] map;
	static boolean[][] vis;
	static List<Integer> ans = new ArrayList<>();
	static Queue<int[]> q = new LinkedList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		vis = new boolean[N][N];
		for(int i=0; i<N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<N; j++) map[i][j]=input[j];
		}
		solve();
		Collections.sort(ans);
		sb.append(cnt).append("\n");
		for(int a : ans) sb.append(a).append("\n");
		System.out.println(sb);
	}
	
	static void solve() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]=='0' || vis[r][c]) continue;
				cnt++;
				vis[r][c]=true;
				q.add(new int[] {r,c});
				int tmp=0;
				while(!q.isEmpty()) {
					cur = q.poll();
					tmp++;
					for(int dir=0; dir<4; dir++) {
						int nr = cur[0]+dr[dir];
						int nc = cur[1]+dc[dir];
						if(nr<0||nr>=N||nc<0||nc>=N) continue;
						if(map[nr][nc]=='0' || vis[nr][nc]) continue;
						vis[nr][nc]=true;
						q.add(new int[] {nr,nc});
					}
				}
				ans.add(tmp);
			}
		}
	}
}