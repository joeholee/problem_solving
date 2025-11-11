import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int ans;
	static int[][] A;
	static int[][] nutritions;
	static Deque<Tree>[][] trees;
	static List<Tree> dead = new ArrayList<>();
	static int N,M,K;
	static final int[] dr = {-1,-1,-1,0,0,1,1,1};
	static final int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	static class Tree implements Comparable<Tree> {
		int r,c,age;
		
		Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
		
		@Override
		public int compareTo(Tree t) {
			return Integer.compare(age, t.age);
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		nutritions = new int[N][N];
		trees = new ArrayDeque[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) A[r][c] = Integer.parseInt(st.nextToken());
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				trees[r][c] = new ArrayDeque<>();
				nutritions[r][c] = 5;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees[x-1][y-1].add(new Tree(x-1,y-1,z));
		}
		for(int i=0; i<K; i++) simulate();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) ans+=trees[r][c].size();
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void simulate() {
		spring();
		summer();
		autumn();
		winter();
	}
	
	static void spring() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(trees[r][c].isEmpty()) continue;
				Deque<Tree> q = new ArrayDeque<>();
				while(!trees[r][c].isEmpty()) {
					Tree t = trees[r][c].poll();
					if(nutritions[r][c]>=t.age) {
						nutritions[r][c]-=t.age;
						t.age++;
						q.offer(t);
					} else dead.add(t);
				}
				trees[r][c] = q;
			}
		}
	}
	
	static void summer() {
		for(Tree t : dead) nutritions[t.r][t.c]+=t.age/2;
		dead.clear();
	}
	
	static void autumn() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(trees[r][c].isEmpty()) continue;
				for(Tree t : trees[r][c]) {
					if(t.age%5!=0) continue;
					for(int dir=0; dir<8; dir++) {
						int nr = t.r+dr[dir];
						int nc = t.c+dc[dir];
						if(nr<0||nr>=N||nc<0||nc>=N) continue;
						trees[nr][nc].offerFirst(new Tree(nr,nc,1));
					}
				}
			}
		}
	}
	
	static void winter() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) nutritions[r][c]+=A[r][c];
		}
	}
}