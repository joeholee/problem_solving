import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans;
	static int[] W;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		W = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) W[i] = Integer.parseInt(st.nextToken());
		vis = new boolean[N];
		dfs(0,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int depth, int cur) {
		if(depth==N-2) {
			ans = Math.max(ans, cur);
			return;
		}
		for(int i=1; i<N-1; i++) {
			if(!vis[i]) {
				int prev=-1, nxt=-1;
				for(int p=i-1; p>=0; p--) {
					if(!vis[p]) {
						prev=p;
						break;
					}
				}
				for(int n=i+1; n<N; n++) {
					if(!vis[n]) {
						nxt=n;
						break;
					}
				}
				vis[i]=true;
				dfs(depth+1,cur+W[prev]*W[nxt]);
				vis[i]=false;
			}
		}
	}
}