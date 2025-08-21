import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,a,b;
	static int[] arr,tree;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = 1 << (h+1);
		tree = new int[size];
		init(1,1,N);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(min(1,1,N,a,b)).append('\n');
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
			tree[node] = Math.min(tree[node*2], tree[node*2+1]);
		}
	}
	
	static int min(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return MAX;
		if(left<=start&&end<=right) return tree[node];
		int mid = (start+end)/2;
		return Math.min(min(node*2, start, mid, left, right), min(node*2+1, mid+1, end, left, right));
	}
}