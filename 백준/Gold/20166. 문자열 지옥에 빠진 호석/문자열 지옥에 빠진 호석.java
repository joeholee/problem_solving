import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,k;
	static String[] words;
	static Map<String,Integer> map = new HashMap<>();
	static char[][] arr;
	static final int[] dr = {-1,-1,-1,0,1,1,1,0};
	static final int[] dc = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<M; c++) arr[r][c] = line.charAt(c);
		}
		words = new String[k];
		for(int i=0; i<k; i++) words[i] = br.readLine();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) dfs(r,c,new StringBuilder());
		}
		for(String w : words) sb.append(map.getOrDefault(w, 0)).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dfs(int r, int c, StringBuilder cur) {
		cur.append(arr[r][c]);
		String s = cur.toString();
		map.put(s, map.getOrDefault(s, 0)+1);
		if(cur.length()==5) {
			cur.setLength(cur.length()-1);
			return;
		}
		for(int dir=0; dir<8; dir++) {
			int nr = (r+dr[dir]+N)%N;
			int nc = (c+dc[dir]+M)%M;
			dfs(nr,nc,cur);
		}
		cur.setLength(cur.length()-1);
	}
}