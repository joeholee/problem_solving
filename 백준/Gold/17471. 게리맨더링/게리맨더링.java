import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] people;
	static List<Integer>[] adjList;
	static boolean[] vis,sel;
	static Queue<Integer> q = new LinkedList<>();
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		vis = new boolean[N+1];
		sel = new boolean[N+1];
		adjList = new ArrayList[N+1];
		for(int i=0; i<=N; i++) adjList[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) people[i] = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int n=0; n<num; n++) {
				int adj=Integer.parseInt(st.nextToken());
				adjList[i].add(adj);
				adjList[adj].add(i);
			}
		}
		divide(1);
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}
	
	// 구역 나누기
	static void divide(int idx) {
		if(idx==N+1) {
			if(isConnected()) {
				int group1=0; int group2=0;
				for(int i=1; i<=N; i++) {
					if(sel[i]) group1+=people[i];
					else group2+=people[i];
				}
				ans=Math.min(ans, Math.abs(group1-group2));
			}
			return;
		}
		sel[idx]=true;
		divide(idx+1);
		sel[idx]=false;
		divide(idx+1);
	}
	
	static boolean isConnected() {
		Arrays.fill(vis, false);
		int start1=-1; int start2=-1;
		for(int i=1; i<=N; i++) {
			if(sel[i]) start1=i;
			else start2=i;
		}
		if(start1==-1 || start2==-1) return false;
		bfs(start1,true);
		bfs(start2,false);
		for(int i=1; i<=N; i++) if(!vis[i]) return false;
		return true;
	}
	
	static void bfs(int start, boolean group) {
		q.add(start);
		vis[start]=true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : adjList[cur]) {
				if(!vis[nxt] && sel[nxt]==group) {
					vis[nxt]=true;
					q.add(nxt);
				}
			}
		}
	}
}