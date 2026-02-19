#include <bits/stdc++.h>
using namespace std;
#define R first
#define C second
int N,M,a[9][9],vis[9][9],ret;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
vector<pair<int,int>> cand;
queue<pair<int,int>> q;
void bfs() {
    for(auto r : vis) fill(r,r+M,0);
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(a[r][c]==2) q.push({r,c});
        }
    }
    while(!q.empty()) {
        auto cur = q.front();
        q.pop();
        vis[cur.R][cur.C]=1;
        for(int dir=0; dir<4; dir++) {
            int nr=cur.R+dr[dir];
            int nc=cur.C+dc[dir];
            if(nr<0||nr>=N||nc<0||nc>=M) continue;
            if(a[nr][nc]||vis[nr][nc]) continue;
            a[nr][nc]=2;
            q.push({nr,nc});
        }
    }
    int cnt=0;
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            if(!a[r][c]) cnt++;
        }
    }
    ret=max(ret,cnt);
}
void comb(int idx, int cnt) {
    if(cnt==3) {
        int tmp[9][9];
        for(int r=0; r<N; r++) copy(a[r],a[r]+M,tmp[r]);
        bfs();
        for(int r=0; r<N; r++) copy(tmp[r],tmp[r]+M,a[r]);
        return;
    }
    for(int i=idx; i<cand.size(); i++) {
        a[cand[i].R][cand[i].C]=1;
        comb(i+1,cnt+1);
        a[cand[i].R][cand[i].C]=0;
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            cin >> a[r][c];
            if(!a[r][c]) cand.push_back({r,c});
        }
    }
    comb(0,0);
    cout << ret << '\n';
    return 0;
}