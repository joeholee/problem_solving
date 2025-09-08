import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Set<Integer> A,B;
	static int ans;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		A = new HashSet<>();
		B = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) A.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			int val = Integer.parseInt(st.nextToken());
			if(A.contains(val)) A.remove(val);
			else B.add(val);
		}
		ans = A.size()+B.size();
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}