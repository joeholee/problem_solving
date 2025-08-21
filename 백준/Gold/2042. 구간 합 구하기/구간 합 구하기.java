import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,K;
	static long[] arr,tree;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new long[N+1];
		for(int i=1; i<=N; i++) arr[i] = Long.parseLong(br.readLine());
		int k = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = 1 << (k+1);
		tree = new long[size];
		init(1,1,N);
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				long diff = c-arr[b];
				arr[b] = c;
				update(1,1,N,b,diff);
			} else sb.append(sum(1,1,N,b,(int) c)).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void init(int node, int start, int end) {
		if(start==end) tree[node]=arr[start];
		else {
			int mid = (start+end)/2;
			init(node*2,start,mid);
			init(node*2+1,mid+1,end);
			tree[node] = tree[node*2]+tree[node*2+1];
		}
	}
	
	static long sum(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return 0;
		if(left<=start&&end<=right) return tree[node];
		int mid = (start+end)/2;
		return sum(node*2,start,mid,left,right) + sum(node*2+1,mid+1,end,left,right);
	}
	
	static void update(int node, int start, int end, int idx, long diff) {
		if(idx<start||end<idx) return;
		tree[node]+=diff;
		if(start==end) return;
		int mid = (start+end)/2;
		update(node*2,start,mid,idx,diff);
		update(node*2+1,mid+1,end,idx,diff);
	}
	
}