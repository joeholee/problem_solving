import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans=Integer.MIN_VALUE;
	static int[][] arr;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]==1) q.add(new int[] {r,c,0});
			}
		}
		bfs();
		for(int[] r : arr) {
			for(int c : r) ans=Math.max(ans, c);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<8; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(arr[nr][nc]!=0) continue;
				arr[nr][nc]=cur[2]+1;
				q.offer(new int[] {nr,nc,cur[2]+1});
			}
		}
	}
}