import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] A;
	static List<Integer> li = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		solve();
		bw.write(li.size()+"");
		bw.close();
		br.close();
	}
	
	static void solve() {
		for(int i=0; i<N; i++) {
			if(li.isEmpty()||li.get(li.size()-1)<A[i]) li.add(A[i]);
			else {
				int idx=-1;
				int st=0, en=li.size();
				while(st<=en) {
					int mid = (st+en)/2;
					if(li.get(mid)>=A[i]) {
						idx=mid;
						en=mid-1;
					} else st=mid+1;
				}
				li.set(idx, A[i]);
			}
		}
	}
}