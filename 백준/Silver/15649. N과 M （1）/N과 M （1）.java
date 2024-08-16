import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringTokenizer st;
    static int[] arr;
    static int[] num;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<arr.length; i++) arr[i]=i+1;
        num = new int[M];
        vis = new boolean[N];
        perm(0);
        System.out.println(sb);
    }
    
    static void perm(int cnt) {
        if(cnt==M) {
            for(int i : num) sb.append(i+" ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<arr.length; i++) {
            if(!vis[i]) {
                num[cnt]=arr[i];
                vis[i]=true;
                perm(cnt+1);
                vis[i]=false;
            }
        }
    }
}