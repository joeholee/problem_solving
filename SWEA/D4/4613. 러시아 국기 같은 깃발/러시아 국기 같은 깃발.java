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
            char[][] arr = new char[N][M];
            for(int r=0; r<N; r++) {
                String tmp = br.readLine();
            	for(int c=0; c<M; c++) arr[r][c] = tmp.charAt(c);
            }
            int ans=2500;
            int w=0,b=0,r=0;
            for(int i=0; i<N-2; i++) {
                w+=countCol(arr,'W',i);
                b=0;
                for(int j=i+1; j<N-1;j++) {
                    b+=countCol(arr,'B',j);
                    r=0;
                	for(int k=j+1; k<N; k++) {
                    	r+=countCol(arr,'R',k);
                    }
                    ans=Math.min(ans,w+b+r);
                }
            }
            System.out.println("#"+test_case+" "+ans);
		}
	}
    
    static int countCol(char[][] arr, char color, int row) {
        int cnt=0;
    	for(char c : arr[row]) {
        	if(c!=color) cnt++;
        }
        return cnt;
    }
}