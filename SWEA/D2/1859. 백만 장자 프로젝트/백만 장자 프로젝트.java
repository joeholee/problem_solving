import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            long[] price = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) price[i] = Integer.parseInt(st.nextToken());
            long sum=0;
            long curMax=price[N-1];
            for(int i=N-2; i>=0; i--) {
                if(price[i]>curMax) curMax=price[i];
                else sum+=(curMax-price[i]);
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}