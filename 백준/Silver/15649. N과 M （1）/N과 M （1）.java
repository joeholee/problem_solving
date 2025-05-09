import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr,num;
	static boolean[] vis;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		num = new int[M];
		vis = new boolean[N];
		for(int i=0; i<N; i++) arr[i]=i+1;
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int idx) {
		if(idx==M) {
			for(int i : num) sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			if(!vis[i]) {
				num[idx]=arr[i];
				vis[i]=true;
				perm(idx+1);
				vis[i]=false;
			}
		}
	}
}