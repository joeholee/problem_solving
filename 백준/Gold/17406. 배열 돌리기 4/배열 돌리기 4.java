import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,K,ans=Integer.MAX_VALUE;
	static int[][] A;
	static boolean[] vis;
	static Rotate[] rotates;
	
	static class Rotate {
		int r,c,s;
		
		Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) A[r][c] = Integer.parseInt(st.nextToken());
		}
		vis = new boolean[K];
		rotates = new Rotate[K];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotates[i] = new Rotate(r-1,c-1,s);
		}
		perm(0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void perm(int depth) {
		if(depth==K) {
			ans = Math.min(ans, calc());
			return;
		}
		for(int i=0; i<K; i++) {
			if(!vis[i]) {
				rotate(rotates[i].r,rotates[i].c,rotates[i].s);
				vis[i]=true;
				perm(depth+1);
				restore(rotates[i].r,rotates[i].c,rotates[i].s);
				vis[i]=false;
			}
		}
	}
	
	static void rotate(int r, int c, int s) {
		for(int layer=1; layer<=s; layer++) {
			int up = r-layer;
			int down = r+layer;
			int left = c-layer;
			int right = c+layer;
			int tmp = A[up][left];
			for(int i=up; i<down; i++) A[i][left]=A[i+1][left]; // ^
			for(int j=left; j<right; j++) A[down][j]=A[down][j+1]; // <
			for(int i=down; i>up; i--) A[i][right]=A[i-1][right]; // v
			for(int j=right; j>left; j--) A[up][j]=A[up][j-1]; // >
			A[up][left+1]=tmp;
		}
	}
	
	static void restore(int r, int c, int s) {
		for(int layer=1; layer<=s; layer++) {
			int up = r-layer;
			int down = r+layer;
			int left = c-layer;
			int right = c+layer;
			int tmp = A[up][left];
	        for(int j=left; j<right; j++) A[up][j]=A[up][j+1];
	        for(int i=up; i<down; i++) A[i][right]=A[i+1][right];
	        for(int j=right; j>left; j--) A[down][j]=A[down][j-1];
	        for(int i=down; i>up; i--) A[i][left]=A[i-1][left];
	        A[up+1][left]=tmp;
		}
	}
	
	static int calc() {
		int val = Integer.MAX_VALUE;
		for(int r=0; r<N; r++) {
			int tmp = 0;
			for(int c=0; c<M; c++) tmp+=A[r][c];
			val = Math.min(val, tmp);
		}
		return val;
	}
}