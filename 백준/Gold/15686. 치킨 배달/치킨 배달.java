import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,size;
	static int ans = Integer.MAX_VALUE;
	static Queue<int[]> q = new ArrayDeque<>();
	static List<Chicken> ch = new ArrayList<>();
	static Chicken[] pick;
	static int[][] arr;
	
	static class Chicken {
		int r,c;
		
		Chicken(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]==1) q.add(new int[] {r+1,c+1});
				if(arr[r][c]==2) ch.add(new Chicken(r+1,c+1));
			}
		}
		size = ch.size();
		pick = new Chicken[M];
		solve(0,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void solve(int cnt, int idx) {
		if(cnt==M) {
			ans = Math.min(ans, calc());
			return;
		}
		for(int i=idx; i<size; i++) {
			pick[cnt]=ch.get(i);
			solve(cnt+1,i+1);
		}
	}
	
	static int calc() {
		int sum = 0;
		for(int[] house : q) {
			int dist = Integer.MAX_VALUE;
			for(Chicken c : pick) {
				dist = Math.min(dist, Math.abs(house[0]-c.r)+Math.abs(house[1]-c.c));
			}
			sum+=dist;
		}
		return sum;
	}
}