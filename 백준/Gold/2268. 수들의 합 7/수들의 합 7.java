import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static long[] tree,arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int k = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = 1 << (k+1);
		tree = new long[size];
		arr = new long[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==0) {
				int left = Math.min(b, c);
				int right = Math.max(b, c);
				sb.append(sum(1,1,N,left,right)).append('\n');
			}
			else {
				arr[b] = c;
				update(1,1,N,b,c);
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static long sum(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return 0;
		if(left<=start&&right>=end) return tree[node];
		int mid = (start+end)/2;
		return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
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
		tree[node] = tree[node*2]+tree[node*2+1];
	}
}