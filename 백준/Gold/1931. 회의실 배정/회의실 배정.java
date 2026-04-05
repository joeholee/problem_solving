import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,cur,ret,time[][];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		time = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time, (o1,o2) -> {
			if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
			else return Integer.compare(o1[1], o2[1]);
		});
		for(int i=0; i<N; i++) {
			if(cur<=time[i][0]) {
				ret++;
				cur=time[i][1];
			}
		}
		bw.write(ret+"");
		bw.close();
		br.close();
	}
}