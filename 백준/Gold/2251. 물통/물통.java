import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int A,B,C;
	static boolean[][][] vis;
	static int[] cur;
	static List<Integer> ans = new ArrayList<>();
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		vis = new boolean[A+1][B+1][C+1];
		bfs();
		Collections.sort(ans);
		for(int i : ans) sb.append(i).append(" ");
		System.out.println(sb);
	}
	
	static void bfs() {
		q.add(new int[] {0,0,C});
//		vis[0][0][C]=true;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(vis[cur[0]][cur[1]][cur[2]]) continue;
			vis[cur[0]][cur[1]][cur[2]] = true;
			if(cur[0]==0) ans.add(cur[2]);
			if(cur[0]+cur[1]>=B) q.add(new int[] {cur[0]-(B-cur[1]),B,cur[2]});
			else q.add(new int[] {0,cur[0]+cur[1],cur[2]});
			if(cur[0]+cur[2]>=C) q.add(new int[] {cur[0]-(C-cur[2]),cur[1],C});
			else q.add(new int[] {0,cur[1],cur[0]+cur[2]});
			if(cur[0]+cur[1]>=A) q.add(new int[] {A,cur[1]-(A-cur[0]),cur[2]});
			else q.add(new int[] {cur[0]+cur[1],0,cur[2]});
			if(cur[1]+cur[2]>=C) q.add(new int[] {cur[0],cur[1]-(C-cur[2]),C});
			else q.add(new int[] {cur[0],0,cur[1]+cur[2]});
			if(cur[0]+cur[2]>=A) q.add(new int[] {A,cur[1],cur[2]-(A-cur[0])});
			else q.add(new int[] {cur[0]+cur[2],cur[1],0});
			if(cur[1]+cur[2]>=B) q.add(new int[] {cur[0],B,cur[2]-(B-cur[1])});
			else q.add(new int[] {cur[0],cur[1]+cur[2],0});
		}
	}
}