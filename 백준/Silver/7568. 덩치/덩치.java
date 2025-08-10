import java.io.*;
import java.util.*;

public class Main {
	
	static class Person {
		int x,y;
		
		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,x,y;
	static Person[] ppl;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		ppl = new Person[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			ppl[i] = new Person(x,y);
		}
		for(Person p : ppl) {
			int tmp=0;
			for(int i=0; i<N; i++) {
				if(p.x<ppl[i].x && p.y<ppl[i].y) tmp++;
			}
			sb.append(tmp+1).append(' ');
		}
		System.out.println(sb);
	}
}