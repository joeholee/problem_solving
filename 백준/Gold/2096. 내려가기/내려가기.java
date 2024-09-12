import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,max,min;
    static int[][] arr,dp;
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<3; i++) dp[0][i]=arr[0][i];
        calMax();
        calMin();
        System.out.println(max+" "+min);
    }
    
    static void calMax() {
        for(int i=1; i<N; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = arr[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][2] = arr[i][2] + Math.max(dp[i-1][1], dp[i-1][2]);
        }
        max = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
    }
    
    static void calMin() {
        for(int i=1; i<N; i++) {
        	dp[i][0] = arr[i][0] + Math.min(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]));
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][1], dp[i-1][2]);
        }
        min = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
    }
}