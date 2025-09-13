import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,K;
	static int[][] arr,sum;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		sum = new int[N+1][M+1];
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=M; c++) sum[r][c] = sum[r-1][c]+sum[r][c-1]-sum[r-1][c-1]+arr[r-1][c-1];
		}
		K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(query(i,j,x,y)).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static int query(int i, int j, int x, int y) {
		return sum[x][y]-sum[x][j-1]-sum[i-1][y]+sum[i-1][j-1];
	}
}