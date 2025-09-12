import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans=Integer.MAX_VALUE;
	static int[][] arr;
	static List<CCTV> cctvs = new ArrayList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][][] dirs = {
			{},
			{{0},{1},{2},{3}},
			{{0,2},{1,3}},
			{{0,1},{1,2},{2,3},{3,0}},
			{{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
			{{0,1,2,3}}
	};
	
	static class CCTV {
		int r,c,type;
		
		CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]>=1&&arr[r][c]<=5) cctvs.add(new CCTV(r,c,arr[r][c]));
			}
		}
		dfs(0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int depth) {
		if(depth==cctvs.size()) {
			ans = Math.min(ans, count(arr));
			return;
		}
		CCTV cur = cctvs.get(depth);
		for(int[] dir : dirs[cur.type]) {
			List<int[]> li = new ArrayList<>();
			for(int d : dir) watch(cur.r,cur.c,d,li,arr);
			dfs(depth+1);
			for(int[] c : li) arr[c[0]][c[1]]=0;
		}
	}
	
	static void watch(int r, int c, int d, List<int[]> li, int[][] arr) {
		int nr = r+dr[d];
		int nc = c+dc[d];
		while(nr>=0&&nr<N&&nc>=0&&nc<M) {
			if(arr[nr][nc]==6) break;
			if(arr[nr][nc]==0) {
				arr[nr][nc]=-1;
				li.add(new int[] {nr,nc});
			}
			nr+=dr[d];
			nc+=dc[d];
		}
	}
	
	static int count(int[][] arr) {
		int tmp = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) if(arr[r][c]==0) tmp++;
		}
		return tmp;
	}
}