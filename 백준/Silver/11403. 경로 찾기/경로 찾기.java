import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][k]==1 && arr[k][j]==1) arr[i][j]=1;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) sb.append(arr[i][j]).append(' ');
			sb.append('\n');
		}
		System.out.println(sb);
	}
}