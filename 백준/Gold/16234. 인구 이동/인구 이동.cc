#include <bits/stdc++.h>
using namespace std;
#define Y first
#define X second
int N,L,R,ret,A[101][101],vis[101][101];
bool canMove;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
static void bfs(int r, int c) {
    queue<pair<int,int>> q;
    vector<pair<int,int>> v;
    q.push({r,c});
    vis[r][c]=true;
    v.push_back({r,c});
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=cur.Y+dr[dir];
            int nc=cur.X+dc[dir];
            if(nr<0||nr>=N||nc<0||nc>=N) continue;
            if(vis[nr][nc]) continue;
            int diff = abs(A[cur.Y][cur.X]-A[nr][nc]);
            if(L<=diff&&diff<=R) {
                q.push({nr,nc});
                vis[nr][nc]=true;
                canMove=true;
                v.push_back({nr,nc});
            }
        }
    }
    if(canMove) {
        int sum=0;
        for(int i=0; i<v.size(); i++) sum+=A[v[i].Y][v[i].X];
        int avg=sum/v.size();
        for(int i=0; i<v.size(); i++) A[v[i].Y][v[i].X]=avg;
    }
}
static void solve() {
    while(true) {
        canMove=false;
        memset(vis,0,sizeof(vis));
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(!vis[r][c]) bfs(r,c);
            }
        }
        if(!canMove) break;
        ret++;
    }
}
int main() {
    cin >> N >> L >> R;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) cin >> A[r][c];
    }
    solve();
    cout << ret << '\n';
    return 0;
}