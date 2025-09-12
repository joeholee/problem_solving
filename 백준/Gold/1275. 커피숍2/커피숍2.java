import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,Q;
	static long[] tree,arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		arr = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) arr[i] = Long.parseLong(st.nextToken());
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = 1 << (h+1);
		tree = new long[size];
		init(1,1,N);
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			int left = Math.min(x,y);
			int right = Math.max(x,y);
			sb.append(query(1,1,N,left,right)).append('\n');
			update(1,1,N,a,b);
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void init(int node, int start, int end) {
		if(start==end) tree[node] = arr[start];
		else {
			int mid = (start+end)/2;
			init(node*2, start, mid);
			init(node*2+1, mid+1, end);
			tree[node] = tree[node*2]+tree[node*2+1];
		}
	}
	
	static long query(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return 0;
		if(left<=start&&end<=right) return tree[node];
		int mid = (start+end)/2;
		return query(node*2, start, mid, left, right) + query(node*2+1, mid+1, end, left, right);
	}
	
	static void update(int node, int start, int end, int idx, long val) {
		if(idx<start||idx>end) return;
		if(start==end) {
			long diff = val-arr[idx];
			arr[idx] = val;
			tree[node]+=diff;
			return;
		}
		int mid = (start+end)/2;
		update(node*2, start, mid, idx, val);
		update(node*2+1, mid+1, end, idx, val);
		tree[node] = tree[node*2]+tree[node*2+1];
	}
}