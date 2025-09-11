import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,K,ans;
	static final int weight = 500;
	static int[] A;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		vis = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		perm(0,weight);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void perm(int cnt, int cur) {
		if(cur<weight) return;
		if(cnt==N) {
			ans++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(!vis[i]) {
				vis[i]=true;
				perm(cnt+1, cur-K+A[i]);
				vis[i]=false;
			}
		}
	}
}