import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans;
	static int[][] a;
	static int[] pick;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) a[i][j] = Integer.parseInt(st.nextToken());
		}
		pick = new int[3];
		dfs(0,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int idx, int depth) {
		if(depth==3) {
			int tot=0;
			for(int i=0; i<N; i++) {
				int tmp=0;
				for(int j : pick) tmp = Math.max(tmp, a[i][j]);
				tot+=tmp;
			}
			ans = Math.max(ans, tot);
			return;
		}
		for(int i=idx; i<M; i++) {
			pick[depth] = i;
			dfs(i+1,depth+1);
		}
	}
}