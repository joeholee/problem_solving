import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] change = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static int[] dp;
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            dp = new int[change.length];
            for(int i=0; i<change.length; i++) {
                if(change[i]>N) {
                    dp[i]=0;
                    continue;
                }
                int num = N/change[i];
                for(int j=1; j<=num; j++) {
                    N-=change[i];
                    dp[i]++;
                }
            }
            sb.append("#").append(test_case).append("\n");
            for(int n : dp) sb.append(n).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}