#include <bits/stdc++.h>
using namespace std;
#define R first
#define C second
int N,M,ret,dist[51][51];
vector<pair<int,int>> cand,pick;
string a[51];
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void bfs(int r, int c) {
    queue<pair<int,int>> q;
    memset(dist,-1,sizeof(dist));
    dist[r][c]=0;
    q.push({r,c});
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=cur.R+dr[dir];
            int nc=cur.C+dc[dir];
            if(nr<0||nr>=N||nc<0||nc>=M) continue;
            if(dist[nr][nc]!=-1||a[nr][nc]=='W') continue;
            dist[nr][nc]=dist[cur.R][cur.C]+1;
            q.push({nr,nc});
            ret=max(ret,dist[nr][nc]);
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int r=0; r<N; r++) cin >> a[r];
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(a[r][c]=='L') bfs(r,c);
        }
    }
    cout << ret << '\n';
    return 0;
}