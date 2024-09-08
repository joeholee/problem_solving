import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

class Micro {
	int r,c,num,dir;
	
	Micro(int r,int c,int num,int dir) {
		this.r=r;
		this.c=c;
		this.num=num;
		this.dir=dir;
	}
}

class Solution
{
	static int N,M,K,ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] graph;
	static List<Micro> micros;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] sz = br.readLine().split(" ");
			N = Integer.parseInt(sz[0]);
			M = Integer.parseInt(sz[1]);
			K = Integer.parseInt(sz[2]);
			graph = new int[N][N];
			micros = new ArrayList<>();
			for(int i=0; i<K; i++) {
				String[] input = br.readLine().split(" ");
				int r = Integer.parseInt(input[0]);
				int c = Integer.parseInt(input[1]);
				int num = Integer.parseInt(input[2]);
				int dir = Integer.parseInt(input[3]);
				micros.add(new Micro(r,c,num,dir));
				graph[r][c]=1;
			}
			for(int i=0; i<M; i++) {
				move();
				merge();
			}
			ans=0;
			for(Micro m : micros) ans+=m.num;
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static void move() {
		for(Micro m : micros) {
			graph[m.r][m.c]-=1;
			m.r+=dr[m.dir-1];
			m.c+=dc[m.dir-1];
			graph[m.r][m.c]+=1;
			if(m.r==0||m.r==N-1||m.c==0||m.c==N-1) {
				m.num/=2;
				if(m.dir==1) m.dir=2;
				else if(m.dir==2) m.dir=1;
				else if(m.dir==3) m.dir=4;
				else m.dir=3;
			}
		}
	}
	
	static void merge() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(graph[r][c]>1) {
					List<Micro> overlap = new ArrayList<>();
					for(Micro m : micros) {
						if(m.r==r && m.c==c) overlap.add(m);
					}
					int max=0;
					int sum=0;
					int dir=0;
					for(Micro o : overlap) {
						sum+=o.num;
						if(max<o.num) {
							max=o.num;
							dir=o.dir;
						}
					}
					for(Micro o : overlap) micros.remove(o);
					micros.add(new Micro(r,c,sum,dir));
					graph[r][c]=1;
				}
			}
		}
    }
}