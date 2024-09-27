import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static boolean[][] visited; // 해당 지점을 방문했는지 여부.
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N;
	static int nodeNum; // 그래프 노드 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		int cnt = 0;
		
		ArrayList<Integer> nodeNums = new ArrayList<>();
		
		// 1. 행 우선 순회를 하면서 1을 찾는다(아직 탐색하지 않은).
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
//					System.out.println(r+","+c);
					//2. 찾은 1을 시작점으로해서 그래프 탐색 시작
					nodeNum = 1;
					visited[r][c] = true;
					dfs(r, c);
					cnt++;
//					System.out.println("노드의 개수:"+nodeNum);
					nodeNums.add(nodeNum);
				}
			}
		}
		
//		System.out.println("그래프 개수:" + cnt);
		
		
//		for(int r=0; r<N; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
//		for(int r=0; r<N; r++) {
//			System.out.println(Arrays.toString(visited[r]));
//		}
		
		Collections.sort(nodeNums);
		
		System.out.println(nodeNums.size());
		for(int num : nodeNums) {
			System.out.println(num);
		}
	}

	private static void dfs(int r, int c) {
//		System.out.println(r+","+c+" 를 기점으로 DFS 시작");
		// 1. 인접 노드를 찾는다.
		//   - 상하좌우
		//   - 2차원 배열의 경계를 벗어나면 안됨!
		//   - 1인지
		//   - visited: false
		// 2. 인접 노드로 재귀 호출.
		
		// 1. 인접 노드를 찾는다.
		for(int d=0; d<4; d++) {
			int nr = r +dr[d];
			int nc = c +dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(map[nr][nc] == 1 && !visited[nr][nc]) {
				//2. 인접 노드로 재귀호출
				nodeNum++;
				visited[nr][nc] = true;
				dfs(nr, nc);
				
			}
			
			
		}
	}
}