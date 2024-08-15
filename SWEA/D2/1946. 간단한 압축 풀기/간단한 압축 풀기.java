import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br;
	static StringTokenizer st;
	static char[] ans;
    public static void main(String args[]) throws Exception
    {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = Integer.parseInt(br.readLine());
        	int idx=1;
        	ans = new char[201];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		char c = st.nextToken().charAt(0);
        		int k = Integer.parseInt(st.nextToken());
        		for(int j=idx; j<idx+k; j++) ans[j]=c;
        		idx+=k;
        	}
        	System.out.println("#"+test_case);
        	for(int i=1; i<=idx; i++) {
        		System.out.print(ans[i]);
        		if(i%10==0) System.out.println();
        	}
        	System.out.println();
        }
    }
}