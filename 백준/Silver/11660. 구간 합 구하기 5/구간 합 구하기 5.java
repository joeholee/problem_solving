import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] sum;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = new int[N+1][N+1];
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				sum[r][c] = Integer.parseInt(st.nextToken())+sum[r-1][c]+sum[r][c-1]-sum[r-1][c-1];
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int ans= sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1];
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}