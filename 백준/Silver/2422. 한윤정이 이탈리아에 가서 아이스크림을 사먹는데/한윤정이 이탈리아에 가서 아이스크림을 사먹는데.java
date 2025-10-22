import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans;
	static int[] flavors = new int[3];
	static boolean[][] exclude = new boolean[201][201];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			exclude[a][b] = exclude[b][a] = true;
		}
		comb(1,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void comb(int idx, int depth) {
		if(depth==3) {
			int a = flavors[0], b = flavors[1], c = flavors[2];
			if(exclude[a][b]||exclude[b][c]||exclude[c][a]) return;
			ans++;
			return;
		}
		for(int i=idx; i<=N; i++) {
			flavors[depth] = i;
			comb(i+1,depth+1);
		}
	}
}