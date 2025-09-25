import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] A,num;
	static boolean[] vis;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		num = new int[N];
		vis = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		perm(0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void perm(int depth) {
		if(depth==N) {
			calc();
			return;
		}
		for(int i=0; i<N; i++) {
			if(!vis[i]) {
				num[depth] = A[i];
				vis[i] = true;
				perm(depth+1);
				vis[i] = false;
			}
		}
	}
	
	static void calc() {
		int tmp = 0;
		for(int i=0; i<N-1; i++) tmp+=Math.abs(num[i]-num[i+1]);
		ans = Math.max(ans, tmp);
	}
}