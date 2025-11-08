import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static Integer[] tips;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		tips = new Integer[N];
		for(int i=0; i<N; i++) tips[i] = Integer.parseInt(br.readLine());
		Arrays.sort(tips, Collections.reverseOrder());
		for(int i=0; i<N; i++) ans+=(tips[i]-i < 0 ? 0 : tips[i]-i);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}