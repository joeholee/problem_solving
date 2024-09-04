import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n,m,inst,a,b;
    static int[] p; // 대표자 집합
     
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append(" ");
            String[] sz = br.readLine().split(" ");
            n = Integer.parseInt(sz[0]);
            m = Integer.parseInt(sz[1]);
            p = new int[n+1];
            for(int i=1; i<=n; i++) p[i]=i; // make-set
            for(int i=0; i<m; i++) {
                String[] cmd = br.readLine().split(" ");
                inst = Integer.parseInt(cmd[0]);
                a = Integer.parseInt(cmd[1]);
                b = Integer.parseInt(cmd[2]);
                if(inst==0) union(a,b);
                else check(a,b);
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
     
    static void union(int a, int b) {
        p[findSet(b)]=findSet(a);
    }
     
    static void check(int a, int b) {
        sb.append(findSet(a)==findSet(b) ? 1 : 0);
    }
     
    static int findSet(int x) {
        if(x!=p[x]) p[x]=findSet(p[x]);
        return p[x];
    }
}