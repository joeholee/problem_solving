import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,L,idx,ans;
	static int[] T,K,selScore,selKcal;
	public static void main(String args[]) throws Exception
	{
		int TC = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= TC; test_case++)
		{
			String[] cond = br.readLine().split(" ");
			N = Integer.parseInt(cond[0]);
			L = Integer.parseInt(cond[1]);
			T = new int[N];
			K = new int[N];
			selScore = new int[N];
			selKcal = new int[N];
			for(int i=0; i<N; i++) {
				String[] info = br.readLine().split(" ");
				T[i]=Integer.parseInt(info[0]);
				K[i]=Integer.parseInt(info[1]);
			}
			powerset(0);
			System.out.println("#"+test_case+" "+ans);
			ans=0;
		}
	}
	
	static void powerset(int cnt) {
		if(cnt==N) {
			calcsum(selScore, selKcal);
			return;
		}
		selScore[cnt]=T[cnt];
		selKcal[cnt]=K[cnt];
		powerset(cnt+1);
		selScore[cnt]=0;
		selKcal[cnt]=0;
		powerset(cnt+1);
	}
	
	static void calcsum(int[] selScore, int[] selKcal) {
		int score=0,kcal=0;
		for(int s : selScore) score+=s;
		for(int k : selKcal) kcal+=k;
		if(kcal<=L) ans = Math.max(ans,score);
	}
}