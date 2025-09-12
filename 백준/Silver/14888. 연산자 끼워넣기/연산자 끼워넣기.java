import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] A,op;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());
		dfs(1,A[0],0,0,0,0);
		sb.append(max).append('\n').append(min);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dfs(int idx, int val, int add, int sub, int mul, int div) {
		if(idx==N) {
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}
		int nxt = A[idx];
		if(op[0]>add) dfs(idx+1, val+nxt, add+1, sub, mul, div);
		if(op[1]>sub) dfs(idx+1, val-nxt, add, sub+1, mul, div);
		if(op[2]>mul) dfs(idx+1, val*nxt, add, sub, mul+1, div);
		if(op[3]>div) dfs(idx+1, val/nxt, add, sub, mul, div+1);
	}
}