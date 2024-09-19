import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,ans;
	static List<List<Integer>> colleagues;
	static Set<Integer> friends = new HashSet<>(); 
	
	// 1에 연결된 애들에 대해 한번씩만 탐색 -> depth가 2까지만
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		colleagues = new ArrayList<>();
		for(int i=0; i<=n; i++) colleagues.add(new ArrayList<>()); 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			colleagues.get(a).add(b);
			colleagues.get(b).add(a);
		}
		// 1번 친구
		for(int friend : colleagues.get(1)) friends.add(friend);
		// 1번 친구의 친구
		Set<Integer> tmpFriends = new HashSet<>(friends);
		for(int friend : tmpFriends) {
			for(int fof : colleagues.get(friend)) {
				if(fof!=1) friends.add(fof); 
			}
		}
		System.out.println(friends.size());
	}
}