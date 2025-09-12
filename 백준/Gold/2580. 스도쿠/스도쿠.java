import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr = new int[9][9];
	static List<int[]> li = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		for(int r=0; r<9; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<9; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]==0) li.add(new int[] {r,c});
			}
		}
		dfs(0);
	}
	
	static void dfs(int depth) throws IOException {
		if(depth==li.size()) {
			for(int[] r : arr) {
				for(int i : r) sb.append(i).append(' ');
				sb.append('\n');
			}
			bw.write(sb.toString());
			bw.close();
			br.close();
			System.exit(0);
		}
		int[] cur = li.get(depth);
		for(int n=1; n<=9; n++) {
			if(check(cur[0],cur[1],n)) {
				arr[cur[0]][cur[1]]=n;
				dfs(depth+1);
				arr[cur[0]][cur[1]]=0;
			}
		}
	}
	
	static boolean check(int rdx, int cdx, int num) {
		for(int r=0; r<9; r++) if(arr[r][cdx]==num) return false;
		for(int c=0; c<9; c++) if(arr[rdx][c]==num) return false;
		for(int r=rdx/3*3; r<rdx/3*3+3; r++) {
			for(int c=cdx/3*3; c<cdx/3*3+3; c++) if(arr[r][c]==num) return false;
		}
		return true;
	}
}