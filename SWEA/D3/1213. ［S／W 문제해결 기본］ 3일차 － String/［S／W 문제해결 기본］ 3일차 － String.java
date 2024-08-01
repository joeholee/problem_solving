import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int T = Integer.parseInt(st.nextToken());
            String pattern = br.readLine();
            String text = br.readLine();
            int ans=0,pi=0,ti=0;
          while(pi<pattern.length() && ti<text.length()) {
                if(pattern.charAt(pi) != text.charAt(ti)) {
                    ti-=pi;
                    pi=-1;
                }
                if(pi==pattern.length()-1) {
                    ans++;
                    pi=0;
                    continue;
                }
                ti++;
                pi++;
            }
            System.out.println("#"+T+" "+ans);
        }
    }
}