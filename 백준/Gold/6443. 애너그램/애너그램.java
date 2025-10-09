import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static String S;
	static boolean[] vis;
	static Set<String> s = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			S = br.readLine();
			char[] chars = S.toCharArray();
			Arrays.sort(chars);
			S = new String(chars);
			vis = new boolean[S.length()];
			perm(0,"");
			for(String str : s) sb.append(str).append('\n');
			s.clear();
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void perm(int cnt, String cur) {
		if(cnt==S.length()) {
			s.add(cur);
			return;
		}
		for(int i=0; i<S.length(); i++) {
			if(i>0&&S.charAt(i)==S.charAt(i-1)&&!vis[i-1]) continue;
			if(!vis[i]) {
				vis[i]=true;
				perm(cnt+1,cur+S.charAt(i));
				vis[i]=false;
			}
		}
	}
}