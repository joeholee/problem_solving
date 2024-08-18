import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,ans;
	static int[][] dices;
	static int[] opp = {5,3,4,1,2,0};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dices = new int[N][6];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) dices[i][j]=Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<6; i++) search(1,i,0);
		System.out.println(ans);
	}
	
	static void search(int dice, int face, int sum) {
		int tmp=Integer.MIN_VALUE;
		for(int i=0; i<6; i++) {
			if(i==face||i==opp[face]) continue;
			tmp = Math.max(tmp,dices[dice-1][i]);
		}
		sum+=tmp;
		if(dice==N) {
			ans=Math.max(ans,sum);
			return;
		}
		for(int i=0; i<6; i++) {
			if(dices[dice-1][opp[face]]==dices[dice][i]) {
				search(dice+1,i,sum);
				break;
			}
		}
	}
}