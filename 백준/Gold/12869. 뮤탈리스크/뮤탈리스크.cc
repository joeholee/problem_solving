#include <bits/stdc++.h>
using namespace std;
int N,a[3],vis[61][61][61];
queue<tuple<int,int,int>> q;
const int dh[6][3] = {
    {1,3,9},
    {1,9,3},
    {3,1,9},
    {3,9,1},
    {9,1,3},
    {9,3,1}
};
void solve(int a, int b, int c) {
    vis[a][b][c]=1;
    q.push({a,b,c});
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        if(vis[0][0][0]) break;
        for(int d=0; d<6; d++) {
            int na=max(0,get<0>(cur)-dh[d][0]);
            int nb=max(0,get<1>(cur)-dh[d][1]);
            int nc=max(0,get<2>(cur)-dh[d][2]);
            if(vis[na][nb][nc]) continue;
            vis[na][nb][nc]=vis[get<0>(cur)][get<1>(cur)][get<2>(cur)]+1;
            q.push({na,nb,nc});
        }
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) cin >> a[i];
    solve(a[0],a[1],a[2]);
    cout << vis[0][0][0]-1 << '\n';
    return 0;
}