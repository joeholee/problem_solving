import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] U;
	static List<Integer> li = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		U = new int[N];
		for(int i=0; i<N; i++) U[i] = Integer.parseInt(br.readLine());
		Arrays.sort(U);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) li.add(U[i]+U[j]);
		}
		Collections.sort(li);
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>=0; j--) {
				int diff = U[i]-U[j];
				if(Collections.binarySearch(li, diff)>=0) {
					bw.write(U[i]+"");
					bw.close();
					br.close();
					return;
				}
			}
		}
	}
}