import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int K,ans;
	static Wheel[] wheels;
	
	public static void main(String[] args) throws IOException {
		wheels = new Wheel[4];
		for(int i=0; i<4; i++) {
			String S = br.readLine();
			wheels[i] = new Wheel(S);
		}
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			check(idx,dir);
		}
		for(int i=0; i<4; i++) {
			if(wheels[i].get(0)==1) ans+=(1<<i);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void check(int idx, int dir) {
		int[] rotate = new int[4];
		rotate[idx] = dir;
		for(int i=idx; i>0; i--) {
			if((wheels[i].get(6)+wheels[i-1].get(2))==1) rotate[i-1] = -rotate[i];
			else break;
		}
		for(int i=idx; i<3; i++) {
			if((wheels[i].get(2)+wheels[i+1].get(6))==1) rotate[i+1] = -rotate[i];
			else break;
		}
		for(int i=0; i<4; i++) {
			if(rotate[i]!=0) wheels[i].rotate(rotate[i]);
		}
	}
	
	static class Wheel {
		Deque<Integer> q = new ArrayDeque<>();
		
		Wheel(String S) {
			for(char c : S.toCharArray()) q.add(c-'0');
		}
		
		int get(int pos) {
			int idx = 0;
			for(int val : q) {
				if(idx==pos) return val;
				idx++;
			}
			return -1;
		}
		
		void rotate(int dir) {
			if(dir==1) q.addFirst(q.pollLast());
			else q.add(q.poll());
		}
	}
}