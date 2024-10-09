import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	static class Node {
		int val;
		Node left,right;
		
		Node(int val) {
			this.val=val;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String input;
		Node root = new Node(Integer.parseInt(br.readLine()));
		while((input=br.readLine())!=null && !input.isEmpty()) {
			insert(root, Integer.parseInt(input));
		}
		postOrder(root);
		System.out.println(sb);
	}
	
	static void insert(Node node, int val) {
		if(val<node.val) {
			if(node.left==null) node.left = new Node(val);
			else insert(node.left,val);
		}
		else {
			if(node.right==null) node.right = new Node(val);
			else insert(node.right,val);
		}
	}
	
	static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.val).append("\n");
	}
}