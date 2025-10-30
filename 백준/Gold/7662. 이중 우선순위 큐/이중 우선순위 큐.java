import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,k;
	static TreeMap<Integer,Integer> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			k = Integer.parseInt(br.readLine());
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				int val = Integer.parseInt(st.nextToken());
				if(op=='I') map.put(val, map.getOrDefault(val, 0)+1);
				else {
					if(map.isEmpty()) continue;
					int target = (val==1) ? map.lastKey() : map.firstKey();
					map.put(target, map.get(target)-1);
					if(map.get(target)==0) map.remove(target);
				}
			}
			if(map.isEmpty()) sb.append("EMPTY").append('\n');
			else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
			map.clear();
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}