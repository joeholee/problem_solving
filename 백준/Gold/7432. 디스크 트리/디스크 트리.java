import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for(int i=0; i<N; i++) trie.insert(br.readLine().split("\\\\"));
		trie.print(trie.root,0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static class TrieNode {
		Map<String, TrieNode> child = new TreeMap<>();
	}
	
	static class Trie {
		TrieNode root = new TrieNode();
		
		public void insert(String[] S) {
			TrieNode cur = root;
			for(String dir : S) {
				cur.child.putIfAbsent(dir, new TrieNode());
				cur = cur.child.get(dir);
			}
		}
		
		public void print(TrieNode node, int depth) {
			for(String dir : node.child.keySet()) {
				for(int i=0; i<depth; i++) sb.append(" ");
				sb.append(dir).append("\n");
				print(node.child.get(dir), depth+1);
			}
		}
	}
}