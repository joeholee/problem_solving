import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int i = 0; i <= 9; i++) {
				int a = Integer.parseInt(st.nextToken());
				if(a%2 == 1)
					sum +=a;
			}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
			
		}
		System.out.println(sb.toString());
		
	}

}