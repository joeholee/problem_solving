import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N,M,K,i,j,x,y;
	static int[][] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		arr = new int[N+1][M+1];
		for(int r=1; r<=N; r++) {
			String[] row = br.readLine().split(" ");
			for(int c=1; c<=M; c++) arr[r][c]=Integer.parseInt(row[c-1]);
		}
		K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			String[] pos = br.readLine().split(" ");
			i = Integer.parseInt(pos[0]);
			j = Integer.parseInt(pos[1]);
			x = Integer.parseInt(pos[2]);
			y = Integer.parseInt(pos[3]);
			int tmp=0;
			for(int r=i; r<=x; r++) {
				for(int c=j; c<=y; c++) tmp+=arr[r][c];
			}
			sb.append(tmp).append("\n");
		}
		System.out.println(sb);
	}
}