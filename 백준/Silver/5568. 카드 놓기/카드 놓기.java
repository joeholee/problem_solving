import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,k;
	static int[] arr;
	static boolean[] vis;
	static Set<Integer> s = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
		vis = new boolean[n];
		dfs(0,"");
		bw.write(s.size()+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int cnt, String cur) {
		if(cnt==k) {
			s.add(Integer.parseInt(cur));
			return;
		}
		for(int i=0; i<n; i++) {
			if(!vis[i]) {
				vis[i]=true;
				dfs(cnt+1,cur+arr[i]);
				vis[i]=false;
			}
		}
	}
}