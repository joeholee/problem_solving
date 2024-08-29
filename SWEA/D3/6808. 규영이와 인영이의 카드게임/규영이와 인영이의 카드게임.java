import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution
{
    static int T,win,lose;
    static int[] gyu = new int[9];
    static int[] in = new int[9];
    static int[] num = new int[9];
    static boolean[] sel = new boolean[19];
    static boolean[] vis = new boolean[9];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
     
    public static void main(String args[]) throws Exception
    {
        T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                sel[gyu[i]]=true;
            }
            int idx=0;
            for(int i=1; i<=18; i++) {
                if(!sel[i]) {
                    num[idx++]=i;
                }
                if(idx==9) break;
            }
            card(0);
            sb.append("#"+test_case+" "+win+" "+lose);
            System.out.println(sb);
            sb.setLength(0);
            Arrays.fill(sel,false);
            win=0; lose=0;
        }
    }
     
    static void card(int cnt) {
        if(cnt==9) {
            int gcore=0,icore=0;
            for(int i=0; i<9; i++) {
                if(gyu[i]>in[i]) gcore+=gyu[i]+in[i];
                else icore+=gyu[i]+in[i];
            }
            if(gcore>icore) win++;
            else if(gcore<icore) lose++;
            return;
        }
        for(int i=0; i<9; i++) {
            if(!vis[i]) {
                in[cnt]=num[i];
                vis[i]=true;
                card(cnt+1);
                vis[i]=false;
            }
        }
    }
}