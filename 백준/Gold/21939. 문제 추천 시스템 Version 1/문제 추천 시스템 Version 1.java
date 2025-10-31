import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static TreeSet<int[]> ts = new TreeSet<>(
			(a,b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
	static Map<Integer,Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			ts.add(new int[] {P,L});
			map.put(P, L);
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch(op) {
			case "recommend":
				int num = Integer.parseInt(st.nextToken());
				sb.append(num==1 ? ts.last()[0] : ts.first()[0]).append('\n');
				break;
			case "add":
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				ts.add(new int[] {P,L});
				map.put(P, L);
				break;
			case "solved":
				int sP = Integer.parseInt(st.nextToken());
				int sL = map.get(sP);
				ts.remove(new int[] {sP,sL});
				map.remove(sP);
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}