import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static int ans,m1,d1,m2,d2;
	static StringTokenizer st;
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	st = new StringTokenizer(br.readLine());
        	m1 = Integer.parseInt(st.nextToken());
        	d1 = Integer.parseInt(st.nextToken());
        	m2 = Integer.parseInt(st.nextToken());
        	d2 = Integer.parseInt(st.nextToken());
        	if(m1==m2) ans+=d2-d1+1;
        	else {
        		ans+=days[m1]-d1+1;
        		for(int i=m1+1; i<m2; i++) {
        			ans+=days[i];
        		}
        		ans+=d2;
        	}
        	System.out.println("#"+test_case+" "+ans);
        	ans=0;
        }
        
    }
}