import java.io.*;
import java.util.*;

public class Main {
	static class TrieNode {
		Map<Character, TrieNode> child = new HashMap<>();
		boolean terminal = false;
	}
	
	static class Trie {
		TrieNode root = new TrieNode();
		
		public void insert(String S) {
			TrieNode cur = root;
			for(int i=0; i<S.length(); i++) {
				char c = S.charAt(i);
				cur.child.putIfAbsent(c, new TrieNode());
				cur = cur.child.get(c);
			}
			cur.terminal = true;
		}
		
		boolean searchPrefix(String S) {
			TrieNode cur = root;
			for(int i=0; i<S.length(); i++) {
				char c = S.charAt(i);
				if(!cur.child.containsKey(c)) return false;
				cur = cur.child.get(c);
			}
			return true;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		for(int i=0; i<N; i++) trie.insert(br.readLine());
		for(int i=0; i<M; i++) {
			if(trie.searchPrefix(br.readLine())) ans++;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}