import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr,num;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		num = new int[N];
		vis = new boolean[N];
		for(int i=0; i<N; i++) arr[i] = i+1;
		perm(0,0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void perm(int idx, int cnt) {
		if(cnt==N) {
			for(int i : num) sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			if(!vis[i]) {
				num[idx] = arr[i];
				vis[i] = true;
				perm(idx+1,cnt+1);
				vis[i] = false;
			}
		}
	}
}