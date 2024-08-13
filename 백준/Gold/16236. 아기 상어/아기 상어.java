import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
	// 거리 > 위 > 왼쪽 순이므로 순회 시 상좌우하 순으로 돈다
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int[] cur = null;
		for(int r=0; r<N; r++) {
			String[] row = br.readLine().split(" ");
			for(int c=0; c<N; c++) {
				arr[r][c] = Integer.parseInt(row[c]);
				// 상어 위치 찾으면 해당 좌표 저장하고 0으로 초기화
				if(arr[r][c]==9) {
					cur = new int[] {r,c};
					arr[r][c]=0;
				}
			}
		}
		int curSize=2;
		int fish=0;
		int dist=0;
		while(true) {
			PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2) ->
					o1[2]!=o2[2] ? Integer.compare(o1[2],o2[2]) : (o1[0]!=o2[0] ? Integer.compare(o1[0],o2[0]) : Integer.compare(o1[1],o2[1]))
			);
			boolean[][] vis = new boolean[N][N];
			PQ.add(new int[] {cur[0],cur[1],0});
			vis[cur[0]][cur[1]]=true;
			boolean eat = false;
			while(!PQ.isEmpty()) {
				cur = PQ.poll();
				// 상어가 이동 후 먹는 케이스: 이차원 배열 해당 좌표가 0이 아니고 수가 현재 사이즈보다 작음
				if(arr[cur[0]][cur[1]]!=0 && arr[cur[0]][cur[1]]<curSize) {
					// 물고기 냠냠
					arr[cur[0]][cur[1]]=0;
					fish++;
					// 거리만큼 총 거리에 추가
					dist+=cur[2];
					eat=true;
					break;
				}
				
				for(int dir=0; dir<4; dir++) {
					int nr = cur[0]+dr[dir];
					int nc = cur[1]+dc[dir];
					// 못 지나가는 경우 (기존 경계 + 이미 간 곳 + 현재 상어보다 큰 경우)
					if(nr<0||nr>=N||nc<0||nc>=N||vis[nr][nc]||arr[nr][nc]>curSize) continue;
					// BFS 특징: 인접한 좌표는 현재 좌표 거리+1임을 활용
					PQ.add(new int[] {nr,nc,cur[2]+1});
					vis[nr][nc]=true;
				}
			}
			// 더 이상 먹을 수 없는 경우
			if(!eat) break;
			// 현재 크기만큼 먹었다면 크기 1 키워주고 먹은 물고기 개수 초기화
			if(curSize==fish) {
				curSize++;
				fish=0;
			}
		}
		System.out.println(dist);
	}
}
