#include <bits/stdc++.h>
using namespace std;
int N,M,a[9][9],ret;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void bfs() {
    queue<pair<int,int>> q;
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(a[r][c]==2) q.push({r,c});
        }
    }
    int vis[9][9];
    for(int r=0; r<N; r++) copy(a[r],a[r]+M,vis[r]);
    while(!q.empty()) {
        int r,c;
        tie(r,c)=q.front();
        q.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=r+dr[dir];
            int nc=c+dc[dir];
            if(nr<0||nr>=N||nc<0||nc>=M) continue;
            if(vis[nr][nc]) continue;
            vis[nr][nc]=2;
            q.push({nr,nc});
        }
    }
    int tmp = 0;
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(!vis[r][c]) tmp++;
        }
    }
    ret=max(ret,tmp);
}
void dfs(int cnt) {
    if(cnt==3) {
        bfs();
        return;
    }
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(!a[r][c]) {
                a[r][c]=1;
                dfs(cnt+1);
                a[r][c]=0;
            }
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) cin >> a[r][c];
    }
    dfs(0);
    cout << ret << '\n';
    return 0;
}