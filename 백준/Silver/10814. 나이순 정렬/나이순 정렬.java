import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Member[] members;
	
	static class Member implements Comparable<Member> {
		int age;
		String name;
		
		Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member o) {
			return Integer.compare(age, o.age);
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		members = new Member[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members[i] = new Member(age,name);
		}
		Arrays.sort(members);
		for(Member m : members) sb.append(m.age).append(' ').append(m.name).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}