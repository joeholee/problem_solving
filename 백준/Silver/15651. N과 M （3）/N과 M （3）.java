import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] num;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        num = new int[M];
        for(int i=0; i<arr.length; i++) arr[i]=i+1;
        perm(0);
        System.out.print(sb);
    }
    
    static void perm(int cnt) {
        if(cnt==M) {
            for(int i : num) sb.append(i+" ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<arr.length; i++) {
            num[cnt]=arr[i];
            perm(cnt+1);
        }
    }
}