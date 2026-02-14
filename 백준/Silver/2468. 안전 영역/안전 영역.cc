#include <bits/stdc++.h>
using namespace std;
#define R first
#define C second
int N,a[101][101],vis[101][101],mx,tmp,ret=1;
queue<pair<int,int>> q;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void bfs(int r, int c, int i) {
    vis[r][c]=1;
    q.push({r,c});
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=cur.R+dr[dir];
            int nc=cur.C+dc[dir];
            if(nr<0||nr>=N||nc<0||nc>=N) continue;
            if(vis[nr][nc]||a[nr][nc]<=i) continue;
            vis[nr][nc]=1;
            q.push({nr,nc});
        }
    }
}
void solve(int i) {
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) {
            if(!vis[r][c]&&a[r][c]>i) {
                tmp++;
                bfs(r,c,i);
            }
        }
    }
    ret=max(ret,tmp);
    tmp=0;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) {
            cin >> a[r][c];
            mx = max(mx,a[r][c]);
        }
    }
    for(int i=1; i<mx; i++) {
        for(auto r : vis) fill(r,r+101,0);
        solve(i);
    }
    cout << ret << '\n';
    return 0;
}