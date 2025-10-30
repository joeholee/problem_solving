import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static Map<String, Set<String>> groups = new HashMap<>();
	static Map<String, String> members = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			String group = br.readLine();
			int size = Integer.parseInt(br.readLine());
			groups.put(group, new TreeSet<>());
			for(int j=0; j<size; j++) {
				String member = br.readLine();
				members.put(member, group);
				groups.get(group).add(member);
			}
		}
		for(int i=0; i<M; i++) {
			String query = br.readLine();
			int type = Integer.parseInt(br.readLine());
			if(type==1) sb.append(members.get(query)).append('\n');
			else {
				for(String member : groups.get(query)) sb.append(member).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}