import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for(char c : input) System.out.print(c-'A'+1+" ");
	}
}