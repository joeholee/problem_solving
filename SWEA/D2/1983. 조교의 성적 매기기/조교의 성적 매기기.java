import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    static String[] grades = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] NK = br.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);
            double[] gpa = new double[N];
            double tgt = 0;
            for(int i=0; i<N; i++) {
            	String[] scores = br.readLine().split(" ");
                int mid = Integer.parseInt(scores[0]);
                int fin = Integer.parseInt(scores[1]);
                int hw = Integer.parseInt(scores[2]);
                gpa[i] = mid*0.35 + fin*0.45 + hw*0.2;
                if(i==K-1) tgt=gpa[i];
            }
            Arrays.sort(gpa);
            int idx=0;
            for(int i=0; i<N; i++) {
            	if(gpa[i]==tgt) {
                	idx=i;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+grades[9-idx/(N/10)]);
		}
	}
}