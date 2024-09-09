import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int ans;
    static int[] rate = new int[4];
    static int[] plan = new int[12];
    static Queue<Integer> q;
     
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++) rate[i]=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<12; i++) plan[i]=Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;
            dfs(0,0);
            sb.append(ans);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
     
    static void dfs(int month, int total) {
        if(month>=12) {
            ans = Math.min(ans,total);
            return;
        }
        int cur = plan[month];
        int payDaily = cur*rate[0];
        dfs(month+1,total+payDaily);
        dfs(month+1,total+rate[1]);
        if(month<=9) dfs(month+3,total+rate[2]);
        dfs(month+12,total+rate[3]);
    }
}