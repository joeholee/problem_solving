import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] X,tmp;
	static List<Integer> li = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		X = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
			tmp[i] = X[i];
		}
		Arrays.sort(tmp);
		for(int i=0; i<N; i++) {
			if(i==0||tmp[i-1]!=tmp[i]) li.add(tmp[i]);
		}
		Collections.sort(li);
		for(int i=0; i<N; i++) {
			sb.append(Collections.binarySearch(li, X[i])).append(' ');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}