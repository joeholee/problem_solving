import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Set<Integer> s = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) s.add(Integer.parseInt(br.readLine()));
		for(int i : s) sb.append(i).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}