import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out: for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<Integer> con = new ArrayList<>();
            String[] input = br.readLine().split(" ");
            for(int i=0; i<N; i++) con.add(Integer.parseInt(input[i]));
            Collections.sort(con);
            int min = Collections.min(con);
            int max = Collections.max(con);
            if(min<M) {
                System.out.println("#"+test_case+" Impossible");
                continue;
            }
            int[] breads = new int[(max/M)+1];
            int sum = 0;
            for(int c : con) breads[c/M]++;
            for(int i=1; i<=max/M; i++) {
                sum+=breads[i];
                if(sum>i*K) {
                    System.out.println("#"+test_case+" Impossible");
                    continue out;
                }
            }
            System.out.println("#"+test_case+" Possible");
        }
    }
}