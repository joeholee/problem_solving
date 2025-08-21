import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,M,a,b,min,max;
	static int[] arr,minT,maxT;
	static final int MIN = Integer.MIN_VALUE;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
		int h = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = 1 << (h+1);
		minT = new int[size];
		maxT = new int[size];
		init(1,1,N);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(queryMin(1,1,N,a,b)).append(' ').append(queryMax(1,1,N,a,b)).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void init(int node, int start, int end) {
		if(start==end) {
			minT[node]=maxT[node]=arr[start];
		} else {
			int mid = (start+end)/2;
			init(2*node,start,mid);
			init(2*node+1,mid+1,end);
			minT[node] = Math.min(minT[node*2], minT[node*2+1]);
			maxT[node] = Math.max(maxT[node*2], maxT[node*2+1]);
		}
	}
	
	static int queryMin(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return MAX;
		if(left<=start&&end<=right) return minT[node];
		int mid = (start+end)/2;
		return Math.min(queryMin(node*2,start,mid,left,right), queryMin(node*2+1,mid+1,end,left,right));
	}
	
	static int queryMax(int node, int start, int end, int left, int right) {
		if(left>end||right<start) return MIN;
		if(left<=start&&end<=right) return maxT[node];
		int mid = (start+end)/2;
		return Math.max(queryMax(node*2,start,mid,left,right), queryMax(node*2+1,mid+1,end,left,right));
	}
}