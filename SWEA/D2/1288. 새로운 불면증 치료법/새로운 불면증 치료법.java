import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] checked = new boolean[10];
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            int K = 1;
            out: while(true) {
                int ans = N*K;
            	while(ans>0) {
                	int d = ans%10;
                    if(!checked[d]) checked[d]=true;
                    ans/=10;
                }
                for(boolean b : checked) {
                	if(!b) {
                        K++;
                        continue out;
                    }
                }
                break;
            }
            System.out.println("#"+test_case+" "+K*N);
            Arrays.fill(checked,false);
		}
	}
}