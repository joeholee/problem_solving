import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int H,W,ans;
	static char[][] arr;
	static int[][] sand;
	static Queue<int[]> q = new ArrayDeque<>();
	static final int[] dr = {-1,-1,-1,0,1,1,1,0};
	static final int[] dc = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new char[H][W];
		sand = new int[H][W];
		for(int r=0; r<H; r++) {
			String line = br.readLine();
			for(int c=0; c<W; c++) arr[r][c] = line.charAt(c);
		}
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				if(arr[r][c]=='.') continue;
				int cnt = 0;
				for(int dir=0; dir<8; dir++) {
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					if(nr<0||nr>=H||nc<0||nc>=W) continue;
					if(arr[nr][nc]=='.') cnt++;
				}
				sand[r][c]=cnt;
				if(sand[r][c]>=arr[r][c]-'0') q.offer(new int[] {r,c,0});
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1], time = cur[2];
			ans = Math.max(ans, time);
			if(arr[r][c]=='.') continue;
			arr[r][c]='.';
			for(int dir=0; dir<8; dir++) {
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr<0||nr>=H||nc<0||nc>=W) continue;
				sand[nr][nc]++;
				if(sand[nr][nc]>=arr[nr][nc]-'0') q.offer(new int[] {nr,nc,time+1});
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}