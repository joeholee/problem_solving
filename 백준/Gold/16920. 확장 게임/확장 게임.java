import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,P;
	static char[][] arr;
	static int[] S;
	static int[] castle;
	static List<Queue<int[]>> li = new ArrayList<>();
	static final int[] dr = {-1,0,0,1};
	static final int[] dc = {0,-1,1,0};
 	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		S = new int[P+1];
		castle = new int[P+1];
		for(int i=0; i<=P; i++) li.add(new ArrayDeque<>());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=P; i++) S[i] = Integer.parseInt(st.nextToken());
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<M; c++) {
				arr[r][c] = line.charAt(c);
				if(arr[r][c]>='1'&&arr[r][c]<='9') {
					li.get(arr[r][c]-'0').offer(new int[] {r,c});
					castle[arr[r][c]-'0']++;
				}
			}
		}
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int p=1; p<=P; p++) {
				for(int i=0; i<S[p]; i++) {
					int size = li.get(p).size();
					if(size==0) break;
					for(int j=0; j<size; j++) {
						int[] cur = li.get(p).poll();
						for(int dir=0; dir<4; dir++) {
							int nr = cur[0]+dr[dir];
							int nc = cur[1]+dc[dir];
							if(nr<0||nr>=N||nc<0||nc>=M) continue;
							if(arr[nr][nc]!='.') continue;
							castle[p]++;
							arr[nr][nc] = (char) (p+'0');
							li.get(p).offer(new int[] {nr,nc});
							flag=true;
						}
					}
				}
			}
		}
		for(int i=1; i<=P; i++) sb.append(castle[i]).append(' ');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}