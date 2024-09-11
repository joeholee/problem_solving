import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int N,ans;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] res; // 이닝별 결과
	static int[] order = new int[9]; // 타순
	static boolean[] vis = new boolean[9];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		res = new int[N][9];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) res[i][j]=Integer.parseInt(st.nextToken());
		}
		// 1번 선수는 4번 타순에 고정
		order[3]=0;
		vis[0]=true;
		perm(0);
		System.out.println(ans);
	}
	
	static void perm(int cnt) {
		if(cnt==9) {
			ans=Math.max(ans,calcScore());
			return;
		}
		// 4번 타순 고정
		if(cnt==3) {
			perm(cnt+1);
			return;
		}
		for(int i=1; i<9; i++) {
			if(!vis[i]) {
				vis[i]=true;
				order[cnt]=i;
				perm(cnt+1);
				vis[i]=false;
			}
		}
	}
	
	static int calcScore() {
		int sum=0;
		int idx=0;
		
		for(int i=0; i<N; i++) {
			int[] base = new int[3];
			int outCnt=0;
			while(outCnt<3) {
				if(res[i][order[idx]]==0) outCnt++;
				else if(res[i][order[idx]]==1) {
					sum+=base[2];
					base[2]=base[1];
					base[1]=base[0];
					base[0]=1;
				}
				else if(res[i][order[idx]]==2) {
					sum+=base[2]+base[1];
					base[2]=base[0];
					base[1]=1;
					base[0]=0;
				}
				else if(res[i][order[idx]]==3) {
					sum+=base[2]+base[1]+base[0];
					base[2]=1;
					base[1]=0;
					base[0]=0;
				}
				else {
					sum+=base[2]+base[1]+base[0]+1;
					base[2]=0;
					base[1]=0;
					base[0]=0;
				}
				idx=(idx+1)%9;
			}
		}
		return sum;
	}
}