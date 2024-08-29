import java.io.BufferedReader;
import java.io.InputStreamReader;
 
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board;
    static char[] cmd;
    static int[] cur;
    static int[] dir = new int[2];
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int H,W,N;
     
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] sz = br.readLine().split(" ");
            H = Integer.parseInt(sz[0]);
            W = Integer.parseInt(sz[1]);
            board = new char[H][W];
            for(int r=0; r<H; r++) {
                char[] row = br.readLine().toCharArray();
                for(int c=0; c<W; c++) {
                    board[r][c]=row[c];
                    if(board[r][c]=='^'||board[r][c]=='>'||board[r][c]=='v'||board[r][c]=='<')
                        cur = new int[] {r,c};
                }
            }
            N = Integer.parseInt(br.readLine());
            cmd = br.readLine().toCharArray();
            for(int i=0; i<N; i++) game(cmd[i]);
            System.out.print("#"+test_case+" ");
            for(int r=0; r<H; r++) {
                for(int c=0; c<W; c++) System.out.print(board[r][c]);
                System.out.println();
            }
        }
    }
     
    static void game(char c) {
        if(c=='U') {
            dir = new int[] {dr[0],dc[0]};
            board[cur[0]][cur[1]]='^';
            int nr = cur[0]+dir[0];
            int nc = cur[1]+dir[1];
            if(nr<0||nr>=H||nc<0||nc>=W) return;
            if(board[nr][nc]=='*'||board[nr][nc]=='#'||board[nr][nc]=='-') return;
            board[cur[0]][cur[1]]='.';
            board[nr][nc]='^';
            cur[0]=nr; cur[1]=nc;
        }
        else if(c=='D') {
            dir = new int[] {dr[2],dc[2]};
            board[cur[0]][cur[1]]='v';
            int nr = cur[0]+dir[0];
            int nc = cur[1]+dir[1];
            if(nr<0||nr>=H||nc<0||nc>=W) return;
            if(board[nr][nc]=='*'||board[nr][nc]=='#'||board[nr][nc]=='-') return;
            board[cur[0]][cur[1]]='.';
            board[nr][nc]='v';
            cur[0]=nr; cur[1]=nc;
        }
        else if(c=='L') {
            dir = new int[] {dr[3],dc[3]};
            board[cur[0]][cur[1]]='<';
            int nr = cur[0]+dir[0];
            int nc = cur[1]+dir[1];
            if(nr<0||nr>=H||nc<0||nc>=W) return;
            if(board[nr][nc]=='*'||board[nr][nc]=='#'||board[nr][nc]=='-') return;
            board[cur[0]][cur[1]]='.';
            board[nr][nc]='<';
            cur[0]=nr; cur[1]=nc;
        }
        else if(c=='R') {
            dir = new int[] {dr[1],dc[1]};
            board[cur[0]][cur[1]]='>';
            int nr = cur[0]+dir[0];
            int nc = cur[1]+dir[1];
            if(nr<0||nr>=H||nc<0||nc>=W) return;
            if(board[nr][nc]=='*'||board[nr][nc]=='#'||board[nr][nc]=='-') return;
            board[cur[0]][cur[1]]='.';
            board[nr][nc]='>';
            cur[0]=nr; cur[1]=nc;
        }
        else {
            if(board[cur[0]][cur[1]]=='^') {
                dir[0]=dr[0];
                dir[1]=dc[0];
            }
            else if(board[cur[0]][cur[1]]=='>') {
                dir[0]=dr[1];
                dir[1]=dc[1];
            }
            else if(board[cur[0]][cur[1]]=='v') {
                dir[0]=dr[2];
                dir[1]=dc[2];
            }
            else {
                dir[0]=dr[3];
                dir[1]=dc[3];
            }
            int nr = cur[0]+dir[0];
            int nc = cur[1]+dir[1];
            while(true) {
                if(nr<0||nr>=H||nc<0||nc>=W) break;
                if(board[nr][nc]=='#') break;
                if(board[nr][nc]=='*') {
                    board[nr][nc]='.';
                    break;
                }
                nr+=dir[0];
                nc+=dir[1];
            }
        }
    }
}