import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static StringTokenizer st;
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = Integer.parseInt(br.readLine());
        	int ans=0;
        	int curVel=0;
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int cmd = Integer.parseInt(st.nextToken());
        		if(cmd==0) {
        			ans+=curVel;
        			continue;
        		}
        		else {
        			int vel = Integer.parseInt(st.nextToken());
        			if(cmd==1) curVel+=vel;
        			else {
        				curVel-=vel;
        				if(curVel<0) curVel=0;
        			}
        			ans+=curVel;
        		}
        	}
        	System.out.println("#"+test_case+" "+ans);
        }
    }
}