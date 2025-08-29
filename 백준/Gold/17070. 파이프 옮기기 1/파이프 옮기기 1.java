import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		dfs(0,1,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	public static void dfs(int r, int c, int dir) {
		if(r==N-1 && c==N-1) {
			ans++;
			return;
		}
		if(dir==0) {
			if(c+1<N && arr[r][c+1]==0) dfs(r,c+1,0);
			if(r+1<N && c+1<N && arr[r+1][c]==0 && arr[r][c+1]==0 && arr[r+1][c+1]==0) dfs(r+1,c+1,2);
		}
		else if(dir==1) {
			if(r+1<N && arr[r+1][c]==0) dfs(r+1,c,1);
			if(r+1<N && c+1<N && arr[r+1][c]==0 && arr[r][c+1]==0 && arr[r+1][c+1]==0) dfs(r+1,c+1,2);
		}
		else {
			if(c+1<N && arr[r][c+1]==0) dfs(r,c+1,0);
			if(r+1<N && arr[r+1][c]==0) dfs(r+1,c,1);
			if(r+1<N && c+1<N && arr[r+1][c]==0 && arr[r][c+1]==0 && arr[r+1][c+1]==0) dfs(r+1,c+1,2);
		}
	}
}