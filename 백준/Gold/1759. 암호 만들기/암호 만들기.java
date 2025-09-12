import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L,C;
	static char[] arr,cand;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		cand = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) arr[i] = st.nextToken().charAt(0);
		Arrays.sort(arr);
		dfs(0,0,0,0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dfs(int idx, int depth, int v, int c) {
		if(v+(C-idx)<1) return;
		if(c+(C-idx)<2) return;
		if(depth==L) {
			if(v>=1&&c>=2) {
				for(char ch : cand) sb.append(ch);
				sb.append('\n');
			}
			return;
		}
		for(int i=idx; i<C; i++) {
			cand[depth]=arr[i];
			if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') dfs(i+1,depth+1,v+1,c);
			else dfs(i+1,depth+1,v,c+1);
		}
	}
}