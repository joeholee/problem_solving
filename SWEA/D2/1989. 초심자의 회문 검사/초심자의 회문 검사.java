import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int T = Integer.parseInt(st.nextToken());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input = br.readLine();
            int res=1;
            for(int i=0; i<input.length()/2; i++) {
                if(input.charAt(i)!=input.charAt(input.length()-1-i)) {
                    res=0;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+res);
        }
    }
}