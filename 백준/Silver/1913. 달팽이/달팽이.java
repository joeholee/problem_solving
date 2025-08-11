import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,dir,query,val;
	static int[] cur, ans;
	static int[][] arr;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		query = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		arr[0][0] = N*N;
		val = arr[0][0];
		cur = new int[] {0,0};
		ans = new int[2];
		int num = N*N;
		while(num-->0) {
			arr[cur[0]][cur[1]]=val;
			if(val==query) {
				ans[0]=cur[0]+1;
				ans[1]=cur[1]+1;
			}
			int nr = cur[0]+dr[dir];
			int nc = cur[1]+dc[dir];
			if(nr<0||nr>=N||nc<0||nc>=N||arr[nr][nc]!=0) dir = (dir+1)%4;
			cur[0]+=dr[dir];
			cur[1]+=dc[dir];
			val--;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(arr[r][c]).append(' ');
			}
			sb.append('\n');
		}
		sb.append(ans[0]).append(' ').append(ans[1]);
		System.out.println(sb);
	}
}