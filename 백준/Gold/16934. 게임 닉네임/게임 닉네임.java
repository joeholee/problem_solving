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
		for(int i=0; i<N; i++) {
			String S = br.readLine();
			sb.append(trie.setPrefix(S)).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static class TrieNode {
		Map<Character, TrieNode> child = new HashMap<>();
		boolean terminal;
		int cnt;
	}
	
	static class Trie {
		TrieNode root = new TrieNode();
		Map<String, Integer> count = new HashMap<>();
		
		public String setPrefix(String S) {
		    TrieNode cur = root;
		    StringBuilder pre = new StringBuilder();
		    String result = null;
		    int call = count.getOrDefault(S, 0) + 1;
		    count.put(S, call);
		    for (char c : S.toCharArray()) {
		        if (!cur.child.containsKey(c)) {
		            cur.child.put(c, new TrieNode());
		            cur = cur.child.get(c);
		            pre.append(c);
		            if (result == null) result = pre.toString();
		        } else {
		            cur = cur.child.get(c);
		            pre.append(c);
		        }
		        cur.cnt++;
		    }
		    cur.terminal = true;
		    if (result == null) {
		        if (call == 1) result = S;
		        else result = S + call;
		    }
		    return result;
		}

	}
}

