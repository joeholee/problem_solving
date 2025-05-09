import java.io.*;
import java.util.*;

public class Main {
	static String S;
	static TreeSet<String> set = new TreeSet<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		S = br.readLine();
		for(int i=0; i<S.length(); i++) set.add(S.substring(i));
		while(!set.isEmpty()) sb.append(set.pollFirst()).append('\n');
		System.out.println(sb);
	}
}