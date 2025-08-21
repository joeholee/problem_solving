import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,K,a,b,c;
	static int[] arr;
	static long[] tree;
	static final int div = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = 1 << (h+1);
		tree = new long[size];
		init(1,1,N);
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a==1) update(1,1,N,b,c);
			else sb.append(mul(1,1,N,b,c)).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void init(int node, int start, int end) {
		if(start==end) tree[node] = arr[start];
		else {
			int mid = (start+end)/2;
			init(node*2,start,mid);
			init(node*2+1,mid+1,end);
			tree[node] = (tree[node*2]%div * tree[node*2+1]%div)%div;
		}
	}
	
	static long mul(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return 1;
		if(left<=start&&end<=right) return tree[node];
		int mid = (start+end)/2;
		long l = mul(node*2, start, mid, left, right);
		long r = mul(node*2+1, mid+1, end, left, right);
		return ((l%div)*(r%div))%div;
		
	}
	
	static void update(int node, int start, int end, int idx, int val) {
		if(idx<start||idx>end) return;
		if(start==end) {
			tree[node] = val;
			return;
		}
		int mid = (start+end)/2;
		update(node*2, start, mid, idx, val);
		update(node*2+1, mid+1, end, idx, val);
		tree[node] = ((tree[node*2]%div)*(tree[node*2+1]%div))%div;
	}
}