import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            for(int i=0; i<N; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j=0; j<N; j++) farm[i][j] = input[j]-'0';
            }
            int ans=0;
            for(int i=0; i<(N+1)/2; i++) {
                for(int j=N/2-i; j<=N/2+i; j++) ans+=farm[i][j];
            }
            for(int i=0; i<N/2; i++) {
                for(int j=i+1; j<N-i-1; j++) ans+=farm[(N+1)/2+i][j];
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}