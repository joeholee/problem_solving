import java.io.*;
import java.util.*;

public class Main {
	static class TrieNode {
		Map<String, TrieNode> child = new TreeMap<>();
		int depth;
	}
	
	static class Trie {
		TrieNode root = new TrieNode();
		
		public void insert(String[] foods) {
			TrieNode cur = root;
			for(String food : foods) {
				cur.child.putIfAbsent(food, new TrieNode());
				cur = cur.child.get(food);
			}
		}
		
		public void print(TrieNode node, int depth) {
			for(String food : node.child.keySet()) {
				for(int i=0; i<depth; i++) sb.append("--");
				sb.append(food).append('\n');
				print(node.child.get(food), depth+1);
			}
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,K;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			String[] foods = new String[K];
			for(int j=0; j<K; j++) foods[j] = st.nextToken();
			trie.insert(foods);
		}
		trie.print(trie.root,0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}