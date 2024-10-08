import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] points;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		points = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) points[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(points);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(findHigherBound(end)-findLowerBound(start)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int findLowerBound(int val) {
		int left=0;
		int right=points.length;
		while(left<right) {
			int mid=(left+right)/2;
			if(points[mid]<val) left=mid+1;
			else right=mid;
		}
		return left;
	}
	
	static int findHigherBound(int val) {
		int left=0;
		int right=points.length;
		while(left<right) {
			int mid=(left+right)/2;
			if(points[mid]<=val) left=mid+1;
			else right=mid;
		}
		return left;
	}
}