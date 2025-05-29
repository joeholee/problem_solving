import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		char val;
		Node left;
		Node right;
		
		Node(char val) {
			this.val = val;
		}
	}
	
	static Map<Character, Node> m = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char tmp = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			m.putIfAbsent(tmp, new Node(tmp));
			Node root = m.get(tmp);
			if(left != '.') {
				m.putIfAbsent(left, new Node(left));
				root.left = m.get(left);
			}
			if(right != '.') {
				m.putIfAbsent(right, new Node(right));
				root.right = m.get(right);
			}
		}
		Node root = m.get('A');
		preOrder(root);
		sb.append('\n');
		inOrder(root);
		sb.append('\n');
		postOrder(root);
		sb.append('\n');
		System.out.println(sb);
	}
	
	static void preOrder(Node node) {
		if(node==null) return;
		sb.append(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void inOrder(Node node) {
		if(node==null) return;
		inOrder(node.left);
		sb.append(node.val);
		inOrder(node.right);
	}
	
	static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.val);
	}
}