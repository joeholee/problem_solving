import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static String game;
	static Set<String> s = new HashSet<>();
 	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		game = st.nextToken();
		for(int i=0; i<N; i++) s.add(br.readLine());
		if(game.equals("Y")) bw.write(s.size()+"");
		else if(game.equals("F")) bw.write(s.size()/2+"");
		else bw.write(s.size()/3+"");
		bw.close();
		br.close();
	}
}