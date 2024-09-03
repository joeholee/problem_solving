import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N+1];
		
		perm(N, M, 0);
		System.out.println(sb);
	}
	
	static void perm(int N, int M, int idx) {
		//기저 조건
		//M개 고른 배열의 요소 갯수는 M개, 인덱스는 M-1개 인덱스가 M개가 되면, return
		if(idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");	
			}
			sb.append("\n");
			return;
		}
		
		//재귀 함수
		//1~N까지를 순회해야 하므로 반복문 사용!, 중복을 허용하지 않으므로, visited 사용
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				arr[idx]=i;
				visited[i] = true;
				perm(N, M, idx+1);
				visited[i]=false;
			}
		}
	}
	
}