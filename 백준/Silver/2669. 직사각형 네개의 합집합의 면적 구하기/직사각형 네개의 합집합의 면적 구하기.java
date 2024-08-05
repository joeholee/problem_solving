import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] vis = new boolean[102][102];
        for(int i=0; i<4; i++) {
            String[] input = br.readLine().split(" ");
            for(int x=Integer.parseInt(input[0]); x<Integer.parseInt(input[2]); x++) {
                for(int y=Integer.parseInt(input[1]); y<Integer.parseInt(input[3]); y++) {
                    vis[x][y]=true;
                }
            }
        }
        int ans=0;
        for(int i=1; i<=100; i++) {
            for(int j=1; j<=100; j++) if(vis[i][j]) ans++;
        }
        System.out.print(ans);
    }
}