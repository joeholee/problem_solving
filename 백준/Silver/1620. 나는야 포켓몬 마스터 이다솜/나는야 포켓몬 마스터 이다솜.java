import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<Integer,String> map1 = new HashMap<>(N);
		HashMap<String,Integer> map2 = new HashMap<>(N);
		for(int i=1; i<=N; i++) {
			String pokemon = br.readLine();
			map1.put(i, pokemon);
			map2.put(pokemon, i);
		}
		for(int i=1; i<=M; i++) {
			String query = br.readLine();
			if(49<=query.charAt(0) && query.charAt(0)<=57) {
				sb.append(map1.get(Integer.parseInt(query)));
			}
			else sb.append(map2.get(query));
			sb.append('\n');
		}
		System.out.println(sb);
	}
}