import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
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
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) move(Integer.parseInt(st.nextToken()));
		for(int[] r : A) {
			for(int c : r) sb.append(c).append(' ');
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void move(int inst) {
		switch(inst) {
		case 1:
			for(int r=0; r<N/2; r++) {
				for(int c=0; c<M; c++) {
					int tmp = A[r][c];
					A[r][c] = A[N-1-r][c];
					A[N-r-1][c] = tmp;
				}
			}
			break;
		case 2:
			for(int r=0; r<N; r++) {
				for(int c=0; c<M/2; c++) {
					int tmp = A[r][c];
					A[r][c] = A[r][M-1-c];
					A[r][M-1-c] = tmp;
				}
			}
			break;
		case 3:
			int[][] cw = new int[A[0].length][A.length];
			for(int r=0; r<cw.length; r++) {
				for(int c=0; c<cw[0].length; c++) cw[r][c] = A[A.length-c-1][r];
			}
			A = cw;
			int tmp = N;
			N = M;
			M = tmp;
			break;
		case 4:
			int[][] ccw = new int[A[0].length][A.length];
			for(int r=0; r<ccw.length; r++) {
				for(int c=0; c<ccw[0].length; c++) ccw[r][c] = A[c][A[0].length-r-1];
			}
			A = ccw;
			int temp = N;
			N = M;
			M = temp;
			break;
		case 5:
			int[][] right = new int[N][M];
			for(int r=0; r<N/2; r++) {
				for(int c=0; c<M/2; c++) right[r][c] = A[r+N/2][c];
				for(int c=M/2; c<M; c++) right[r][c] = A[r][c-M/2];
			}
			for(int r=N/2; r<N; r++) {
				for(int c=0; c<M/2; c++) right[r][c] = A[r][c+M/2];
				for(int c=M/2; c<M; c++) right[r][c] = A[r-N/2][c];
			}
			A = right;
			break;
		case 6:
			int[][] left = new int[N][M];
			for(int r=0; r<N/2; r++) {
				for(int c=0; c<M/2; c++) left[r][c] = A[r][c+M/2];
				for(int c=M/2; c<M; c++) left[r][c] = A[r+N/2][c];
			}
			for(int r=N/2; r<N; r++) {
				for(int c=0; c<M/2; c++) left[r][c] = A[r-N/2][c];
				for(int c=M/2; c<M; c++) left[r][c] = A[r][c-M/2];
			}
			A = left;
			break;
		}
	}
}