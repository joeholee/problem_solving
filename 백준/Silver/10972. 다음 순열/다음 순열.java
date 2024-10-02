import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		if(hasNext()) {
			for(int i : arr) sb.append(i).append(" ");
		} else sb.append(-1);
		System.out.println(sb);
	}
	
	static boolean hasNext() {
		int i = arr.length-1;
		while(i>0 && arr[i-1]>=arr[i]) i--;
		if(i<=0) return false;
		int j = arr.length-1;
		while(arr[i-1]>=arr[j]) j--;
		swap(i-1,j);
		j=arr.length-1;
		while(i<j) {
			swap(i,j);
			i++;
			j--;
		}
		return true;
	}
	
	static void swap(int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}