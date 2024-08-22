import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int N,M,x,y,u,v,cur;
	static int[] board,dist;
	static Queue<Integer> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		board = new int[101];
		dist = new int[101];
		for(int i=1; i<=100; i++) board[i]=i;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			board[x]=y;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			board[u]=v;
		}
		bfs();
		System.out.println(dist[100]-1);
	}
	
	static void bfs() {
		q.add(1);
		dist[1]=1;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int i=1; i<=6; i++) {
				int nxt = cur+i;
				if(nxt>100) continue;
				if(dist[board[nxt]]>0) continue;
				q.add(board[nxt]);
				dist[board[nxt]]=dist[cur]+1;
				if(board[nxt]==100) return;
			}
		}
	}
}