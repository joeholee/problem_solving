import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static final int INF = Integer.MAX_VALUE;
	static int[] tree,A;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) A[i] = Integer.parseInt(st.nextToken());
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = 1 << (h+1);
		tree = new int[size];
		init(1,1,N);
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1) update(1,1,N,b,c);
			else sb.append(query(1,1,N,b,c)).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void init(int node, int start, int end) {
		if(start==end) tree[node] = A[start];
		else {
			int mid = (start+end)/2;
			init(node*2, start, mid);
			init(node*2+1, mid+1, end);
			tree[node] = Math.min(tree[node*2], tree[node*2+1]);
		}
	}
	
	static int query(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return INF;
		if(left<=start&&end<=right) return tree[node];
		int mid = (start+end)/2;
		return Math.min(query(node*2, start, mid, left, right), query(node*2+1, mid+1, end, left, right));
	}
	
	static void update(int node, int start, int end, int idx, int val) {
		if(idx<start||idx>end) return;
		if(start==end) {
			A[idx] = val;
			tree[node] = val;
			return;
		}
		int mid = (start+end)/2;
		update(node*2, start, mid, idx, val);
		update(node*2+1, mid+1, end, idx, val);
		tree[node] = Math.min(tree[node*2], tree[node*2+1]);
	}
}