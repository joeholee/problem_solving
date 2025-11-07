import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int H,W,ans;
	static char[][] arr;
	static Queue<int[]> q = new ArrayDeque<>();
	static final int[] dr = {-1,-1,-1,0,1,1,1,0};
	static final int[] dc = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new char[H][W];
		for(int r=0; r<H; r++) {
			String line = br.readLine();
			for(int c=0; c<W; c++) {
				arr[r][c] = line.charAt(c);
				if(arr[r][c]=='.') q.offer(new int[] {r,c,0});
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			ans = Math.max(ans, cur[2]);
			for(int dir=0; dir<8; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=H||nc<0||nc>=W) continue;
				if(arr[nr][nc]=='.') continue;
				arr[nr][nc]--;
				if(arr[nr][nc]=='0') {
					arr[nr][nc]='.';
					q.offer(new int[] {nr,nc,cur[2]+1});
				}
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}