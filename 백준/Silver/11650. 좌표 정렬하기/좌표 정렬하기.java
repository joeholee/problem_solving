import java.io.*;
import java.util.*;

public class Main {
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.x==p.x) return this.y-p.y;
			return this.x-p.x;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static List<Point> l = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			l.add(new Point(x,y));
		}
		Collections.sort(l);
		for(Point p : l) sb.append(p.x).append(' ').append(p.y).append('\n');
		System.out.println(sb);
	}
}