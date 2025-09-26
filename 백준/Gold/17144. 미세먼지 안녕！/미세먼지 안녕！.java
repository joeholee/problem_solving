import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R,C,T,ans,airTop=-1,airBottom=-1;
	static int[][] arr;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]==-1) {
					if(airTop==-1) airTop=r;
					else airBottom=r;
				}
			}
		}
		for(int t=0; t<T; t++) simulate();
		for(int[] row : arr) {
			for(int c : row) ans+=c;
		}
		ans+=2;
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void simulate() {
		spread();
		move();
	}
	
	static void spread() {
		int[][] tmp = new int[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(arr[r][c]>0) {
					int amount = arr[r][c]/5;
					int cnt = 0;
					for(int dir=0; dir<4; dir++) {
						int nr = r+dr[dir];
						int nc = c+dc[dir];
						if(nr<0||nr>=R||nc<0||nc>=C) continue;
						if(arr[nr][nc]==-1) continue;
						tmp[nr][nc]+=amount;
						cnt++;
					}
					tmp[r][c]+=arr[r][c]-cnt*amount;
				}
			}
		}
		tmp[airTop][0]=-1;
		tmp[airBottom][0]=-1;
		arr=tmp;
	}
	
	static void move() {
		moveTop();
		moveBottom();
	}
	
	static void moveTop() {
		for(int r=airTop; r>0; r--) arr[r][0]=arr[r-1][0];
		for(int c=0; c<C-1; c++) arr[0][c]=arr[0][c+1];
		for(int r=0; r<airTop; r++) arr[r][C-1]=arr[r+1][C-1];
		for(int c=C-1; c>0; c--) arr[airTop][c]=arr[airTop][c-1];
		arr[airTop][1]=0;
		arr[airTop][0]=-1;
	}
	
	static void moveBottom() {
		for(int r=airBottom; r<R-1; r++) arr[r][0]=arr[r+1][0];
		for(int c=0; c<C-1; c++) arr[R-1][c]=arr[R-1][c+1];
		for(int r=R-1; r>airBottom; r--) arr[r][C-1]=arr[r-1][C-1];
		for(int c=C-1; c>0; c--) arr[airBottom][c]=arr[airBottom][c-1];
		arr[airBottom][1]=0;
		arr[airBottom][0]=-1;
	}
}