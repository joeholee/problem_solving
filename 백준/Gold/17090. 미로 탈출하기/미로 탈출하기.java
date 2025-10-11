import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,M,ans;
	static char[][] arr;
	static int[][] state;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int r=0; r<N; r++) {
			String row = br.readLine();
			for(int c=0; c<M; c++) arr[r][c] = row.charAt(c);
		}
		state = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) dfs(r,c);
		}
		for(int[] r : state) {
			for(int i : r) if(i==1) ans++;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int r, int c) {
		if(state[r][c]==1||state[r][c]==2) return;
		if(state[r][c]==-1) {
			state[r][c]=2;
			return;
		}
		state[r][c]=-1;
		char dir = arr[r][c];
		int nr=r, nc=c;
		switch(dir) {
		case 'U':
			nr--;
			break;
		case 'R':
			nc++;
			break;
		case 'D':
			nr++;
			break;
		case 'L':
			nc--;
			break;
		}
		if(nr<0||nr>=N||nc<0||nc>=M) {
			state[r][c]=1;
			return;
		} else {
			dfs(nr,nc);
			state[r][c] = state[nr][nc];
		}
	}
}