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
        int[] dr1 = {-1,1,0,0};
        int[] dc1 = {0,0,-1,1};
        int[] dr2 = {-1,-1,1,1};
        int[] dc2 = {-1,1,1,-1};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++) {
                String[] tmp = br.readLine().split(" ");
                for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(tmp[j]);
            }
            int ans=0;
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    int sum=arr[r][c];
                    for(int dir=0; dir<4; dir++) {
                        for(int pow=1; pow<M; pow++) {
                            int nr = r+pow*dr1[dir];
                            int nc = c+pow*dc1[dir];
                            if(nr<0||nr>=N||nc<0||nc>=N) continue;
                            sum+=arr[nr][nc];
                        }
                    }
                    if(sum>=ans) ans=sum;
                    sum=arr[r][c];
                    for(int dir=0; dir<4; dir++) {
                        for(int pow=1; pow<M; pow++) {
                            int nr = r+pow*dr2[dir];
                            int nc = c+pow*dc2[dir];
                            if(nr<0||nr>=N||nc<0||nc>=N) continue;
                            sum+=arr[nr][nc];
                        }
                    }
                    if(sum>=ans) ans=sum;
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}