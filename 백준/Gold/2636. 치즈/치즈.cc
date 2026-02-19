#include <bits/stdc++.h>
using namespace std;
#define R first
#define C second
int N,M,ret,pre,cnt,a[101][101],vis[101][101];
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void bfs() {
    queue<pair<int,int>> q;
    q.push({0,0});
    vis[0][0]=1;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=cur.R+dr[dir];
            int nc=cur.C+dc[dir];
            if(nr<0||nr>=N||nc<0||nc>=M) continue;
            if(vis[nr][nc]) continue;
            vis[nr][nc]=1;
            if(!a[nr][nc]) q.push({nr,nc});
            else {
                cnt--;
                a[nr][nc]=0;
            }
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            cin >> a[r][c];
            if(a[r][c]) cnt++;
        }
    }
    while(cnt>0) {
        pre=cnt;
        ret++;
        memset(vis,0,sizeof(vis));
        bfs();
    }
    cout << ret << '\n' << pre << '\n';
    return 0;
}