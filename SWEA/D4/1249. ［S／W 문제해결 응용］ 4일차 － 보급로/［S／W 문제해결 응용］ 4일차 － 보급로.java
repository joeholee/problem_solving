import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Solution
{
	static class Node implements Comparable<Node> {
		int r,c,cost;
		
		Node(int r, int c, int cost) {
			this.r=r;
			this.c=c;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] map;
	static int[][] dist;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
    public static void main(String args[]) throws Exception
    {
    	int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++)
        {
        	sb.append("#").append(t).append(" ");
        	N = Integer.parseInt(br.readLine());
        	map = new char[N][N];
        	dist = new int[N][N];
        	for(int r=0; r<N; r++) {
        		char[] row = br.readLine().toCharArray();
        		for(int c=0; c<N; c++) {
        			map[r][c]=row[c];
        			dist[r][c]=Integer.MAX_VALUE;
        		}
        	}
        	solve();
        	sb.append(dist[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }
    
    static void solve() {
    	dist[0][0]=0;
    	pq.add(new Node(0,0,0));
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		for(int dir=0; dir<4; dir++) {
    			int nr=cur.r+dr[dir];
    			int nc=cur.c+dc[dir];
    			if(nr>=0 && nr<N && nc>=0 && nc<N) {
    				int ncost = cur.cost+(map[nr][nc]-'0');
    				if(ncost<dist[nr][nc]) {
    					dist[nr][nc]=ncost;
    					pq.add(new Node(nr,nc,ncost));
    				}
    			}
    		}
    	}
    }
}