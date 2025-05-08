import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N,cnt;
	static char[][] map;
	static boolean[][] vis;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
 	static List<Integer> ans = new ArrayList<>();
 	static StringBuilder sb = new StringBuilder();
 	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		vis = new boolean[N][N];
		for(int r=0; r<N; r++) {
			char[] input = br.readLine().toCharArray();
			for(int c=0; c<N; c++) map[r][c] = input[c];
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]=='1'&&!vis[r][c]) {
					cnt++;
					bfs(r,c);
				}
			}
		}
		Collections.sort(ans);
		sb.append(cnt).append('\n');
		for(int i : ans) sb.append(i).append('\n');
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{r, c});
	    vis[r][c] = true; // 시작점 방문 처리
	    int tmp = 1;       // 시작점 포함
	    while (!q.isEmpty()) {
	        int[] cur = q.poll();
	        for (int dir = 0; dir < 4; dir++) {
	            int nr = cur[0] + dr[dir];
	            int nc = cur[1] + dc[dir];
	            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
	            if (vis[nr][nc] || map[nr][nc] == '0') continue;
	            vis[nr][nc] = true;
	            q.add(new int[]{nr, nc});
	            tmp++;
	        }
	    }
	    ans.add(tmp);
	}
}