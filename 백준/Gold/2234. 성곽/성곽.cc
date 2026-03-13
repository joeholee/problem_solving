#include <bits/stdc++.h>
using namespace std;
#define R first
#define C second
int N,M,a[51][51],vis[51][51],ret1,ret2,ret3;
queue<pair<int,int>> q;
const int dr[] = {0,-1,0,1};
const int dc[] = {-1,0,1,0};
void bfs(int r, int c) {
    int tmp=1;
    vis[r][c]=1;
    q.push({r,c});
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=cur.R+dr[dir];
            int nc=cur.C+dc[dir];
            if(nr<0||nr>=M||nc<0||nc>=N) continue;
            if(vis[nr][nc]) continue;
            if(a[cur.R][cur.C]&(1<<dir)) continue;
            tmp++;
            vis[nr][nc]=1;
            q.push({nr,nc});
        }
    }
    ret2=max(ret2,tmp);
}
void solve() {
    for(int r=0; r<M; r++) {
        for(int c=0; c<N; c++) {
            if(!vis[r][c]) {
                bfs(r,c);
                ret1++;
            }
        }
    }
}
void wall() {
    for(int r=0; r<M; r++) {
        for(int c=0; c<N; c++) {
            for(int dir=0; dir<4; dir++) {
                int nr=r+dr[dir];
                int nc=c+dc[dir];
                if(nr<0||nr>=M||nc<0||nc>=N) continue;
                if(a[r][c]&(1<<dir)) {
                    memset(vis,0,sizeof(vis));
                    a[r][c]&=~(1<<dir);
                    solve();
                    a[r][c]|=(1<<dir);
                }
            }
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int r=0; r<M; r++) {
        for(int c=0; c<N; c++) cin >> a[r][c];
    }
    solve();
    cout << ret1 << '\n' << ret2 << '\n';
    wall();
    cout << ret2;
    return 0;
}