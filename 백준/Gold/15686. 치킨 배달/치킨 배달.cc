#include <bits/stdc++.h>
using namespace std;
#define R first
#define C second
int N,M,a[51][51],vis[51][51],ret=987654321;
vector<pair<int,int>> v,cand,c;
void solve() {
    int tmp=0;
    for(int i=0; i<v.size(); i++) {
        int curR=v[i].R, curC=v[i].C, mn=987654321;
        for(int j=0; j<M; j++) {
            int dist=abs(curR-c[j].first)+abs(curC-c[j].second);
            mn=min(mn,dist);
        }
        tmp+=mn;
    }
    ret=min(ret,tmp);
}
void pick(int cnt, int idx) {
    if(cnt==M) {
        solve();
        return;
    }
    for(int i=idx; i<cand.size(); i++) {
        if(!vis[cand[i].R][cand[i].C]) {
            vis[cand[i].R][cand[i].C]=1;
            c.push_back({cand[i].R,cand[i].C});
            pick(cnt+1,i+1);
            vis[cand[i].R][cand[i].C]=0;
            c.pop_back();
        }
    }
}
int main() {
    cin >> N >> M;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) {
            cin >> a[r][c];
            if(a[r][c]==1) v.push_back({r,c});
            else if(a[r][c]==2) cand.push_back({r,c});
        }
    }
    pick(0,0);
    cout << ret << '\n';
    return 0;
}