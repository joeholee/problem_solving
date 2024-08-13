import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    static int[][] board;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int K = Integer.parseInt(info[1]);
            board = new int[N][N];
            for(int r=0; r<N; r++) {
                String[] row = br.readLine().split(" ");
                for(int c=0; c<N; c++) board[r][c] = Integer.parseInt(row[c]);
            }
            int ans=0;
            for(int r=0; r<N; r++) {
            	int tmp=0;
            	for(int c=0; c<N; c++) {
            		if(board[r][c]==0) {
            			if(tmp==K) ans++;
            			tmp=0;
            		}
            		else tmp++;
            	}
            	if(tmp==K) ans++;
            }
            for(int c=0; c<N; c++) {
            	int tmp=0;
            	for(int r=0; r<N; r++) {
            		if(board[r][c]==0) {
            			if(tmp==K) ans++;
            			tmp=0;
            		}
            		else tmp++;
            	}
            	if(tmp==K) ans++;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}