import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// G: 현재^2-기억^2
// -> (현재+기억)(현재-기억)
// 만약에 100000이면 100000*1이니까 int형 충분
// 작은 약수 큰 약수
// 3 5 -> 4 1
// 1 15 -> 8 2 -> 현재는 큰 약수
// 합쳐서 짝수가 아니면 pass
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> li = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static int G;
	public static void main(String[] args) throws IOException {
		G = Integer.parseInt(br.readLine());
		for(int i=1; i*i<G; i++) {
			if(G%i==0) {
				if((i+(G/i))%2!=0) continue;
				li.add((i+G/i)/2);
			}
		}
		Collections.sort(li);
		if(li.isEmpty()) sb.append(-1);
		else {
			for(int i : li) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}

