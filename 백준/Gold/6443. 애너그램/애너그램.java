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
		boolean[] used = new boolean[26];
		for(int i=0; i<S.length(); i++) {
			if(!vis[i]&&!used[S.charAt(i)-'a']) {
				vis[i]=true;
				used[S.charAt(i)-'a']=true;
				perm(cnt+1,cur+S.charAt(i));
				vis[i]=false;
			}
		}
	}
}