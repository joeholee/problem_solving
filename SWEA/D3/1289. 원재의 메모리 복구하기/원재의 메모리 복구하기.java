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
            int ans=0;
            char curC;
            char[] input = br.readLine().toCharArray();
            for(int i=0; i<input.length-1; i++) {
            	if(input[i]!=input[i+1]) ans++;
            }
            if(input[0]=='1') ans++;
            System.out.println("#"+test_case+" "+ans);
		}
	}
}