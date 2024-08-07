import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
 
class Solution
{
    public static void main(String args[]) throws Exception
    { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> ans = new ArrayList<>();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int diff=0;
            if(N==M) ans.add(N+1);
            else if(N>M) {
                diff=N-M;
                for(int i=diff; i>=0; i--) ans.add(N+1-i); 
            }
            else {
                diff=M-N;
                for(int i=diff; i>=0; i--) ans.add(M+1-i);
            }
            System.out.print("#"+test_case+" ");
            for(int i : ans) System.out.print(i + " ");
            System.out.println();
            ans.clear();
        }
    }
}