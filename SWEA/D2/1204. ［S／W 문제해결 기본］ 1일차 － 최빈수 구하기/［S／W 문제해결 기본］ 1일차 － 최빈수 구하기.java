import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int[] scores = new int[101];
	static StringTokenizer st;
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	scores = new int[101];
        	for(int i=0; i<1000; i++) scores[Integer.parseInt(st.nextToken())]++;
        	int ans=Integer.MIN_VALUE;
        	int tmp=Integer.MIN_VALUE;
        	for(int i=0; i<=100; i++) {
        		if(scores[i]>=tmp) {
        			tmp=scores[i];
        			ans=i;
        		}
        	}
        	System.out.println("#"+N+" "+ans);
        }
    }
}