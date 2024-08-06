import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        char[][] game = new char[n][n];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n; j++) board[i][j]=input.charAt(j);
        }
        int[] dr = {-1,-1,-1,0,1,1,1,0};
        int[] dc = {-1,0,1,1,1,0,-1,-1};
        boolean shouldReveal=false;
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n; j++) game[i][j]=input.charAt(j);
        }
        out: for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                int cnt=0;
                if(game[r][c]=='x') {
                    if(board[r][c]=='*') shouldReveal=true;
                    for(int dir=0;dir<8;dir++) {
                        int nr=r+dr[dir];
                        int nc=c+dc[dir];
                        if(nr<0||nr>=n||nc<0||nc>=n) continue;
                        if(board[nr][nc]=='*') cnt++;
                        
                    }
                    game[r][c]=Character.forDigit(cnt,10);
                }
            }
        }
        if(shouldReveal) revealMines(board,game,n);
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                System.out.print(game[r][c]);
            }
            System.out.println();
        }
    }
    
    static void revealMines(char[][]board, char[][] game, int n) {
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(board[r][c]=='*') game[r][c]='*';
                if(game[r][c]=='x') game[r][c]='.';
            }
        }
    }
}