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
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] A = new int[N];
            int[] B = new int[M];
            String[] a = br.readLine().split(" ");
            for(int i=0; i<N; i++) A[i] = Integer.parseInt(a[i]);
            String[] b = br.readLine().split(" ");
            for(int i=0; i<M; i++) B[i] = Integer.parseInt(b[i]);
            int max=Integer.MIN_VALUE;
            if(N>=M) {
            	for(int i=0; i<N-M+1; i++) {
                    int sum=0;
                	for(int j=0; j<M; j++) sum+=A[i+j]*B[j];
                    max = Math.max(max,sum);
                }
            }
            else {
            	for(int i=0; i<M-N+1; i++) {
                	int sum=0;
                    for(int j=0; j<N; j++) sum+=A[j]*B[i+j];
                    max = Math.max(max,sum);
                }
            }
            System.out.println("#"+test_case+" "+max);
		}
	}
}