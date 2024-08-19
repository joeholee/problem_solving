import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] input;
	static int A,B;
	public static void main(String args[]) throws IOException
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			input = br.readLine().split(" ");
			A = Integer.parseInt(input[0]);
			B = Integer.parseInt(input[1]);
			System.out.println("#"+test_case+" "+(A+B)%24);
		}
	}
}