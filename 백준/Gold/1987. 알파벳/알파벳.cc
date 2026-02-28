#include <bits/stdc++.h>
using namespace std;
int R,C,ret=1;
string S;
char a[21][21];
bool vis[26];
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void dfs(int r, int c, int cnt) {
    ret=max(ret,cnt);
    for(int dir=0; dir<4; dir++) {
        int nr=r+dr[dir];
        int nc=c+dc[dir];
        if(nr<0||nr>=R||nc<0||nc>=C) continue;
        if(!vis[a[nr][nc]-'A']) {
            vis[a[nr][nc]-'A']=true;
            dfs(nr,nc,cnt+1);
            vis[a[nr][nc]-'A']=false;
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> R >> C;
    for(int r=0; r<R; r++) {
        cin >> S;
        for(int c=0; c<C; c++) a[r][c]=S[c];
    }
    vis[a[0][0]-'A']=true;
    dfs(0,0,1);
    cout << ret << '\n';
    return 0;
}