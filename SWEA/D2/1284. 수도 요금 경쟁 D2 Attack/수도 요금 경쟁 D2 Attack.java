import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int P,Q,R,S,W,fee1,fee2;
	static StringTokenizer st;
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	st = new StringTokenizer(br.readLine());
        	P = Integer.parseInt(st.nextToken());
        	Q = Integer.parseInt(st.nextToken());
        	R = Integer.parseInt(st.nextToken());
        	S = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	fee1 = P*W;
        	fee2 = Q;
        	if(W>R) fee2+=S*(W-R);
        	System.out.println("#"+test_case+" "+Math.min(fee1,fee2));
        }
    }
}