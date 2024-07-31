import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int T = Integer.parseInt(st.nextToken());
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input = br.readLine();
            st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            int r=0, c=0, dir=0, num=1;
            for(int i=1; i<=N*N; i++) {
                arr[r][c]=num;
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(nr<0||nr>=N||nc<0||nc>=N||arr[nr][nc]!=0) dir = (dir+1)%4;
                r+=dr[dir];
                c+=dc[dir];
                num++;
            }
            System.out.println("#"+test_case);
            for(int i=0; i<N; i++) {
                for(int e : arr[i]) System.out.print(e + " ");
                System.out.println();
            }
        }
    }
}