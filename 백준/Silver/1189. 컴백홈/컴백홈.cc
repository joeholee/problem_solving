#include <bits/stdc++.h>
using namespace std;
int R,C,K,ret,vis[5][5];
char arr[5][5];
string S;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void dfs(int r, int c, int tot) {
    if(tot>K) return;
    if(r==0&&c==C-1) {
        if(tot==K) ret++;
        return;
    }
    for(int dir=0; dir<4; dir++) {
        int nr=r+dr[dir];
        int nc=c+dc[dir];
        if(nr<0||nr>=R||nc<0||nc>=C) continue;
        if(arr[nr][nc]=='T') continue;
        if(!vis[nr][nc]) {
            vis[nr][nc]=1;
            dfs(nr,nc,tot+1);
            vis[nr][nc]=0;
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> R >> C >> K; 
    for(int r=0; r<R; r++) {
        cin >> S;
        for(int c=0; c<C; c++) arr[r][c]=S[c];
    }
    vis[R-1][0]=1;
    dfs(R-1,0,1);
    cout << ret << '\n';
    return 0;
}