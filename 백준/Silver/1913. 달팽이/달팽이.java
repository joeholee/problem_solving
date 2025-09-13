import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N,val,it,dir;
	static int[][] arr;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int[] ans = new int[2];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		val = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		it = N*N;
		int r=0,c=0;
		while(it>0) {
			arr[r][c]=it;
			if(val==it) {
				ans[0]=r+1;
				ans[1]=c+1;
			}
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr<0||nr>=N||nc<0||nc>=N||arr[nr][nc]!=0) dir = (dir+1)%4;
			r+=dr[dir];
			c+=dc[dir];
			it--;
		}
		for(int[] row : arr) {
			for(int i : row) sb.append(i).append(' ');
			sb.append('\n');
		}
		sb.append(ans[0]).append(' ').append(ans[1]);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}