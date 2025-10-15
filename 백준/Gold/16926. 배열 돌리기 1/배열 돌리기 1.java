import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,R;
	static int[][] A;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) A[r][c] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<R; i++) rotate();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) sb.append(A[r][c]).append(' ');
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void rotate() {
		int cnt = Math.min(N, M)/2;
		for(int i=0; i<cnt; i++) {
			int startRow = i;
			int startCol = i;
			int endRow = N-i-1;
			int endCol = M-i-1;
			int tmp = A[startRow][startCol];
			for(int c=startCol; c<endCol; c++) A[startRow][c] = A[startRow][c+1];
			for(int r=startRow; r<endRow; r++) A[r][endCol] = A[r+1][endCol];
			for(int c=endCol; c>startCol; c--) A[endRow][c] = A[endRow][c-1];
			for(int r=endRow; r>startRow; r--) A[r][startCol] = A[r-1][startCol];
			A[startRow+1][startCol] = tmp;
		}
	}
}